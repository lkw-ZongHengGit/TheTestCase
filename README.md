# TheTestCase


gmall-user :ÓÃ»§·þÎñ,¶Ë¿Ú8080

分支：test

测试,增加job1


package com.tax.task.batch.chunk.base;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sword.framework.config.PropertyConfigurer;
import com.sword.framework.constant.ErrorCodeConstants;
import com.sword.framework.dto.ResponseDTO;
import com.sword.framework.dto.SearchDTO;
import com.sword.framework.exception.business.SwordBusinessException;
import com.sword.framework.utils.DateUtil;
import com.tax.base.httpclient.HttpPostSend;
import com.tax.common.constant.BaseConstant;
import com.tax.common.constant.CommonConstants;
import com.tax.common.remote.option.*;
import com.tax.finance.dto.sapconfig.SapJcoConfigDTO;
import com.tax.option.dto.admdivision.AdmDivisionDTO;
import com.tax.option.dto.taxcategory.TaxCategoryDTO;
import com.tax.option.dto.taxpayer.*;
import com.tax.task.constants.JobConstants;
import com.sword.framework.utils.JsonUtils;
import com.tax.task.constants.TaskErrorCodeConstants;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 折旧重跑 默认重跑当月
 */
@Component(JobConstants.PUSH_TO_AFILING_DATA_NAME)
public class PushToAfilTask implements Tasklet {
    @Autowired
    private OptionTaxpayerFeignService optionTaxpayerFeignService;
    @Autowired
    private OptionTaxCategoryFeignService optionTaxCategoryFeignService;
    @Autowired
    private OptionAdmDivisionFeignService optionAdmDivisionFeignService;
    @Autowired
    private OptionTaxItemFeignService optionTaxItemFeignService;



    @Autowired
    private AssociationFeignService associationFeignService;


    @Value("${Push.ToAfil.Taxpayer}")
    private String pushAfilTaxpayerUrl;
    @Value("${Push.ToAfil.Taxcategory}")
    private String pushAfilTaxcategoryUrl;
    @Value("${Push.ToAfil.Taxregion}")
    private String pushAfilTaxregionUrl;
    @Value("${Push.ToAfil.Taxrate}")
    private String pushAfilTaxrateUrl;
    @Value("${Push.ToAfil.Taxdictionary}")
    private String pushAfilTaxdictionaryUrl;

    private static ObjectMapper objectMapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    private static final Logger logger = LoggerFactory.getLogger(PushToAfilTask.class);
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        String paramStr = chunkContext.getStepContext().getStepExecution()
                .getJobParameters().getString("taskParam");
        if (Strings.isBlank(paramStr)) {
            //paramStr为null，执行定时任务逻辑
            Date date = DateUtil.reduceDays(new Date(), 1);
            Date dateDayStart = DateUtil.getDateDayStart(date);
            sendTaxSubject(dateDayStart);
            sendTaxManagement(dateDayStart);
            sendTaxRegion(dateDayStart);
            sendTaxRate(dateDayStart);
            sendTaxDictionary(dateDayStart);
            return RepeatStatus.FINISHED;
        }
        Map<String, String> paramMap = JsonUtils.jsonToMap(paramStr, String.class, String.class);
        if (!Strings.isBlank(paramMap.get("pushId"))) {
            //获取字典表
            String selectedPushDate = paramMap.get("selectedPushDate");
            Date date = formatDate(selectedPushDate);
            String pushId = paramMap.get("pushId");
            switch (pushId) {
                case "TAX_SUBJECT":
                    sendTaxSubject(date);
                    System.out.println("纳税主体推送");
                    break;
                case "TAX_MANAGEMENT":
                    sendTaxManagement(date);
                    System.out.println("税种推送");
                    break;
                case "TAX_REGION":
                    sendTaxRegion(date);
                    System.out.println("区域推送");
                    break;
                case "TAX_RATE":
                    sendTaxRate(date);
                    System.out.println("税率推送");
                    break;
                case "TAX_DICTIONARY":
                    sendTaxDictionary(date);
                    System.out.println("字典表推送");
                    break;
            }
        } else {
            //参数不为空，但推送类型为空
            String selectedPushDate = paramMap.get("selectedPushDate");
            Date dateDayStart = formatDate(selectedPushDate);
            sendTaxSubject(dateDayStart);
            sendTaxManagement(dateDayStart);
            sendTaxRegion(dateDayStart);
            sendTaxRate(dateDayStart);
            sendTaxDictionary(dateDayStart);
        }
        return RepeatStatus.FINISHED;
    }


    //同步纳税主体
    private void sendTaxSubject(Date selectedPushDate) throws ParseException {
        //获取纳税主体发送的数据
        TaxpayerPushCustDTo taxpayerDTO = new TaxpayerPushCustDTo();
        taxpayerDTO.setSystemPoint(selectedPushDate);
        List<TaxpayerPushCustDTo> taxpayerCustList = optionTaxpayerFeignService.queryTaxpayerPushAllList(taxpayerDTO).getData();
        if(CollectionUtils.isEmpty(taxpayerCustList)){
            return;
        }
        List<TaxpayerPushDTo> taxpayerList = taxpayerCustList.stream().map(custDto -> {
            TaxpayerPushDTo taxpayerPushDTo = new TaxpayerPushDTo();
            BeanUtils.copyProperties(custDto, taxpayerPushDTo);
            return taxpayerPushDTo;
        }).collect(Collectors.toList());
        String body = sendPostDate(taxpayerList, pushAfilTaxpayerUrl);
        Map result = JSONObject.parseObject(body, Map.class);
        if((int)result.get("code")!=200){
            logger.error("税企直连系统返回报错:{},返回报文:{}",result.get("msg"),result);
            throw new SwordBusinessException(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL, PropertyConfigurer.getErrorMessage(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL));
        }

    }

    //同步税种信息
    private void sendTaxManagement(Date selectedPushDate) throws ParseException {
        TaxCategoryDTO taxCategoryDTO = new TaxCategoryDTO();
        taxCategoryDTO.setSystemPoint(selectedPushDate);
        //查询税种
        ResponseDTO<List<TaxCategoryDTO>> listResponseDTO = optionTaxCategoryFeignService.queryTaxCategoryList(taxCategoryDTO);
        if(CollectionUtils.isEmpty(listResponseDTO.getData())){
            return;
        }
        List<TaxCategoryDTO> taxCategoryDTOS = listResponseDTO.getData();
        List<TaxCategoryPushDTo> taxCategoryPushList = taxCategoryDTOS.stream().map(custDto -> {
            TaxCategoryPushDTo taxCategoryPushDTo = new TaxCategoryPushDTo();
            BeanUtils.copyProperties(custDto, taxCategoryPushDTo);
            return taxCategoryPushDTo;
        }).collect(Collectors.toList());
        String body = sendPostDate(taxCategoryPushList,pushAfilTaxcategoryUrl);
        Map result = JSONObject.parseObject(body, Map.class);
        if((int)result.get("code")!=200){
            logger.error("税企直连系统返回报错:{},返回报文:{}",result.get("msg"),result);
            throw new SwordBusinessException(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL, PropertyConfigurer.getErrorMessage(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL));
        }
    }

    //同步区域信息
    private void sendTaxRegion(Date selectedPushDate) throws ParseException {
        TaxCategoryDTO taxCategoryDTO = new TaxCategoryDTO();
        taxCategoryDTO.setSystemPoint(selectedPushDate);
        List<AdmDivisionDTO> data = optionAdmDivisionFeignService.queryPushProvinceAndCity(taxCategoryDTO).getData();
        if(CollectionUtils.isEmpty(data)){
            return;
        }
        List<TaxAdmDivisionPushDTO> taxAdmDivisionPushList = data.stream().map(custDto -> {
            TaxAdmDivisionPushDTO taxAdmDivisionPushDTO = new TaxAdmDivisionPushDTO();
            BeanUtils.copyProperties(custDto, taxAdmDivisionPushDTO);
            return taxAdmDivisionPushDTO;
        }).collect(Collectors.toList());
        String body = sendPostDate(taxAdmDivisionPushList,pushAfilTaxregionUrl);
        Map result = JSONObject.parseObject(body, Map.class);
        if((int)result.get("code")!=200){
            logger.error("税企直连系统返回报错:{},返回报文:{}",result.get("msg"),result);
            throw new SwordBusinessException(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL, PropertyConfigurer.getErrorMessage(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL));
        }
    }

    //同步税率
    private void sendTaxRate(Date selectedPushDate) throws ParseException {
        TaxRatePushItemCustDTo taxRatePushItemCustDTO = new TaxRatePushItemCustDTo();
        taxRatePushItemCustDTO.setSystemPoint(selectedPushDate);
        List<TaxRatePushItemCustDTo> taxRatePushItemCustDTo = optionTaxItemFeignService.queryTaxRatePushItemAllList(taxRatePushItemCustDTO).getData();
        if(CollectionUtils.isEmpty(taxRatePushItemCustDTo)){
            return;
        }
        List<TaxRatePushItemDTo> collect = taxRatePushItemCustDTo.stream().map(custDto -> {
            TaxRatePushItemDTo taxCategoryPushDTo = new TaxRatePushItemDTo();
            BeanUtils.copyProperties(custDto, taxCategoryPushDTo);
            return taxCategoryPushDTo;
        }).collect(Collectors.toList());
        String body = sendPostDate(collect, pushAfilTaxrateUrl);
        Map result = JSONObject.parseObject(body, Map.class);
        if((int)result.get("code")!=200){
            logger.error("税企直连系统返回报错:{},返回报文:{}",result.get("msg"),result);
            throw new SwordBusinessException(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL, PropertyConfigurer.getErrorMessage(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL));
        }
    }

    //同步字典表
    private void sendTaxDictionary(Date selectedPushDate) throws Exception {
        TaxDictionaryItemPushCustDTo taxDictionaryItemPushCustDTo = new TaxDictionaryItemPushCustDTo();
        taxDictionaryItemPushCustDTo.setSystemPoint(selectedPushDate);
        List<TaxDictionaryItemPushCustDTo> taxDictionaryItemPushCustDTos = associationFeignService.queryTaxDictionaryPushItemAllList(taxDictionaryItemPushCustDTo);
        if(CollectionUtils.isEmpty(taxDictionaryItemPushCustDTos)){
            return;
        }
        List<TaxDictionaryItemPushDTo> collect = taxDictionaryItemPushCustDTos.stream().map(custDto -> {
            TaxDictionaryItemPushDTo taxCategoryPushDTo = new TaxDictionaryItemPushDTo();
            BeanUtils.copyProperties(custDto, taxCategoryPushDTo);
            return taxCategoryPushDTo;
        }).collect(Collectors.toList());
        String body = sendPostDate(collect, pushAfilTaxdictionaryUrl);
        Map result = JSONObject.parseObject(body, Map.class);
        if((int)result.get("code")!=200){
            logger.error("税企直连系统返回报错:{},返回报文:{}",result.get("msg"),result);
            throw new SwordBusinessException(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL, PropertyConfigurer.getErrorMessage(TaskErrorCodeConstants.MSG_TASK_HTTP_DEFINE_PUSH_DATE_AFIL));
        }
    }

    private String sendPostDate(List taxpayerList,String url){
        HttpPostSend httpPostSend = new HttpPostSend();
        //对账系统回写路径
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String ret = httpPostSend.sendPostNoToken(url, list2Json(taxpayerList));
            return ret;
        } catch (Exception e) {
            logger.error("Retail error", e);;
            throw new RuntimeException("同步纳税主体失败！");
        }
    }

    //格式化时间字符串
    private Date formatDate(String parm) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = dateFormat.parse(parm);
        return parse;
    }


    public static String list2Json(List list){
        try {
            return objectMapper.writeValueAsString(list);
        }catch (Exception e){

        }
        return null;
    }

    public static void main(String[] args) {

        Object ss = "nihao";


    }
}
