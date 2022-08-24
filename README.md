# TheTestCase


gmall-user :ÓÃ»§·þÎñ,¶Ë¿Ú8080

分支：test

测试,增加job1



mapper层的方法：


自己写过的算法：
 private Boolean checkRedInvoiceInfo(String redinvoiceInfoTable) {
        int sumNum = 0, result = 0;
        if (!redinvoiceInfoTable.matches("^[0-9]*$")) {
            return true;
        }
        // 新建一个数组用来保存每一位的数字
        int[] intArray = new int[redinvoiceInfoTable.length()];
        for (int i = 0; i < redinvoiceInfoTable.length(); i++) {
            // 遍历,将每一位数字添加如intArray
            Character ch = redinvoiceInfoTable.charAt(i);
            intArray[i] = Integer.parseInt(ch.toString());
            //获取到的每一位数字相加
            result = intArray[i] + result;
            //只取前十五位的结果,并取个位数
            if (i == intArray.length - 2) {
                sumNum = result % 10;
            }
        }
        if (sumNum != intArray[intArray.length - 1]) {
            return true;
        }
        return false;
    }
------

    /**
     * 新增
     *
     * @param entities
     * @return
     */
    int insertBatch(List<StampdutyItemDTO> entities);
    

    <delete id="cleanTaxReportInstanceByDate" parameterType="java.util.Date">
        delete from afil_tax_return_task where create_time &lt;= #{creatTime,jdbcType=TIMESTAMP}
    </delete>

Maper写法：
     int cleanTaxReportInstanceByDate(@Param("creatTime")Date creatTime);
     
     
curl --location --request GET 'localhost:10010/dfsDownload.do' 
							   





  public static void main(String[] args) {
        String  问题 = "=====>>>  请将你的问题写在这:(道过谦了，但效果微乎其微。。)";


        // 请将问题输入一下输入框
        Gom(问题);
    }











    private static void Gom(String s) {
        String i = s.substring(s.lastIndexOf(":")+1);
        if(i.equals("(智者我惹我心爱的人不高兴了。。)")) {
            System.out.println("==>>  你：智者我惹我心爱的人不高兴了。。");
            System.out.println("==>>  智者：小子是你的问题，你跟你学姐道过谦了吗？");
        }else if(i.equals("(道过谦了，但效果微乎其微。。)")){
            System.out.println("==>>  你：智者我惹我心爱的人不高兴了。。");
            System.out.println("==>>  智者：小子是你的问题，你跟你学姐道过谦了吗？");
            System.out.println("==>>  你：道过谦了，但效果微乎其微。。");
            System.out.println("==>>  智者：本来无一物，何处惹尘埃。");
        }
    }



http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=0d6162347c50eb9910e028181e6555571c575b010b535650024c540009044f51065653195b035a061e02030c5b5c52530357000c00656a65520f165517120317335f&code=3ab49ebe&fid=72/69526451-640a-4571-bf8c-ca8b90606b89






    <update id="updateJudgeDate" parameterType="java.util.List" >
        <foreach collection="list" index="index" item="item" open="" separator=";" close="" >
            update app1_contract_info
            SET judge_date = #{item.judge_date,jdbcType=TIMESTAMP}
            where sys_contract_id = #{item.sys_contract_id,jdbcType=VARCHAR}
        </foreach>
    </update>)
    
    
http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=236431305005be9d41e57b1c413300534d05080457010f045449090954521a550056521d070706044f50030402560e560700555102333c61030a45514e021e4f1505433058&code=bd10f37a&fid=72/a94128e6-892a-4b2c-a41e-424de97eddad

http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=0e3661669707b1ca2ffb7c4814320f041f0e055450040101091b020057051502560f074b520b0d071d015703510a01540601030757323036515815071d4559443008&code=06af3286&fid=72/8d2c6979-cfd7-4f9f-a951-76eb89b67bad&fid=72/8d2c6979-cfd7-4f9f-a951-76eb89b67bad


http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=0e6636329551bac42fab2b1c1564040a1f5053540507015d544b0401545d1e0c55040e1f0a56040b1d5402570201575b025153020b643b38510842531c13524a3058&code=0f622d38&fid=72/6ef7c2ed-23f9-4eb8-8273-24e0edc27e09&fid=72/6ef7c2ed-23f9-4eb8-8273-24e0edc27e09


http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=5b3737345654b8997afa2a1a426106574a025455545750015c1a540607511c515c0e0519070450574806000103055207070e05575c613965045943554b1650176509&code=e774ea1e&fid=72/5ca16ad9-c2b0-4992-bea2-175fdcbb92c9&fid=72/5ca16ad9-c2b0-4992-bea2-175fdcbb92c9




http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftnapp_download&k=073738627908eacf26fa254c11385401160208570e0e00560a1a0c560f014e070e055e4f540a000514565d07000a50510d0e5e5503386b3358594c03184f02413909&code=978b68c3&fid=72/50586ce3-4499-472f-b2c6-aee623b49f75&f=xhtml



http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=0e6433382e17ebc42fa92e164430550a1f0707010151530a0049025c5b534f0c085506150109530c1d5d020c5a545400065d050854306a38510a47594d47034a305a&code=0d38c0b8&fid=72/c49ba120-1d8c-4815-b914-9149d6869607&fid=72/c49ba120-1d8c-4815-b914-9149d6869607



http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=0e3335663246ea9a2ffe2848456154541f00025455595005021e065450524e520951514b035851511d01055e0007050003560d5503616b66515d41074c160214300d&code=035fbacf&fid=72/372783c2-3223-49bd-a927-208bfff3e83a&fid=72/372783c2-3223-49bd-a927-208bfff3e83a



package com.epoch.workflow.util;

import com.epoch.workflow.vo.TaskForcedEndVo;

import java.util.List;

public class OrderAutomaticExecutionMailUtil {
    /**
     * 生成自动结束单据邮件主题
     * @return
     */
    public static String generateOrderAutomaticSubject() {
        return  "月结工单已自动审批通过（重要）";
    }

    /**
     * 生成结束单据预提醒邮件主题
     * @return
     */
    public static String BeforehandSendMailSubject() {
        return  "请及时审批月结待办工单（重要）";
    }


    /**
     * 生成报销费用欠票提醒邮件内容
     * @return
     */
    public static String generateOrderAutomaticContent(TaskForcedEndVo taskForcedEnd) {
        // 单据信息行
        StringBuilder lineContentBuilder = new StringBuilder();
        lineContentBuilder.append(generateBookLineContent(taskForcedEnd));


        // 邮件内容
        return "<html xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
                "xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "xmlns:x=\"urn:schemas-microsoft-com:office:excel\"\n" +
                "xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\"\n" +
                "xmlns=\"http://www.w3.org/TR/REC-html40\">\n" +
                "\n" +
                "<head>\n" +
                "<meta http-equiv=Content-Type content=\"text/html; charset=unicode\">\n" +
                "<meta name=ProgId content=Word.Document>\n" +
                "<meta name=Generator content=\"Microsoft Word 15\">\n" +
                "<meta name=Originator content=\"Microsoft Word 15\">\n" +
                "<style>\n" +
                "<!--\n" +
                " /* Font Definitions */\n" +
                " @font-face\n" +
                "\t{font-family:宋体;\n" +
                "\tpanose-1:2 1 6 0 3 1 1 1 1 1;\n" +
                "\tmso-font-alt:SimSun;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:auto;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:3 680460288 22 0 262145 0;}\n" +
                "@font-face\n" +
                "\t{font-family:\"Cambria Math\";\n" +
                "\tpanose-1:2 4 5 3 5 4 6 3 2 4;\n" +
                "\tmso-font-charset:1;\n" +
                "\tmso-generic-font-family:roman;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:0 0 0 0 0 0;}\n" +
                "@font-face\n" +
                "\t{font-family:等线;\n" +
                "\tpanose-1:2 1 6 0 3 1 1 1 1 1;\n" +
                "\tmso-font-alt:DengXian;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:auto;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:-1610612033 953122042 22 0 262159 0;}\n" +
                "@font-face\n" +
                "\t{font-family:微软雅黑;\n" +
                "\tpanose-1:2 11 5 3 2 2 4 2 2 4;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:swiss;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:-2147483001 718224464 22 0 262175 0;}\n" +
                "@font-face\n" +
                "\t{font-family:\"\\@等线\";\n" +
                "\tpanose-1:2 1 6 0 3 1 1 1 1 1;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:auto;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:-1610612033 953122042 22 0 262159 0;}\n" +
                "@font-face\n" +
                "\t{font-family:\"\\@宋体\";\n" +
                "\tpanose-1:2 1 6 0 3 1 1 1 1 1;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:auto;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:3 680460288 22 0 262145 0;}\n" +
                "@font-face\n" +
                "\t{font-family:\"\\@微软雅黑\";\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:swiss;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:-2147483001 718224464 22 0 262175 0;}\n" +
                " /* Style Definitions */\n" +
                " p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
                "\t{mso-style-unhide:no;\n" +
                "\tmso-style-qformat:yes;\n" +
                "\tmso-style-parent:\"\";\n" +
                "\tmargin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\ttext-align:justify;\n" +
                "\tmso-pagination:widow-orphan;\n" +
                "\tfont-size:10.5pt;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-bidi-font-family:宋体;}\n" +
                "a:link, span.MsoHyperlink\n" +
                "\t{mso-style-noshow:yes;\n" +
                "\tmso-style-priority:99;\n" +
                "\tcolor:#0563C1;\n" +
                "\ttext-decoration:underline;\n" +
                "\ttext-underline:single;}\n" +
                "a:visited, span.MsoHyperlinkFollowed\n" +
                "\t{mso-style-noshow:yes;\n" +
                "\tmso-style-priority:99;\n" +
                "\tcolor:#954F72;\n" +
                "\ttext-decoration:underline;\n" +
                "\ttext-underline:single;}\n" +
                "p.msonormal0, li.msonormal0, div.msonormal0\n" +
                "\t{mso-style-name:msonormal;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tmso-margin-top-alt:auto;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmso-margin-bottom-alt:auto;\n" +
                "\tmargin-left:0cm;\n" +
                "\tmso-pagination:widow-orphan;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:宋体;\n" +
                "\tmso-bidi-font-family:宋体;}\n" +
                "span.EmailStyle18\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle19\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle20\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle21\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle22\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle23\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle24\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle25\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle26\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                ".MsoChpDefault\n" +
                "\t{mso-style-type:export-only;\n" +
                "\tmso-default-props:yes;\n" +
                "\tfont-size:10.0pt;\n" +
                "\tmso-ansi-font-size:10.0pt;\n" +
                "\tmso-bidi-font-size:10.0pt;\n" +
                "\tmso-ascii-font-family:\"Times New Roman\";\n" +
                "\tmso-fareast-font-family:\"Times New Roman\";\n" +
                "\tmso-hansi-font-family:\"Times New Roman\";\n" +
                "\tmso-font-kerning:0pt;}\n" +
                "@page WordSection1\n" +
                "\t{size:612.0pt 792.0pt;\n" +
                "\tmargin:72.0pt 90.0pt 72.0pt 90.0pt;\n" +
                "\tmso-header-margin:36.0pt;\n" +
                "\tmso-footer-margin:36.0pt;\n" +
                "\tmso-paper-source:0;}\n" +
                "div.WordSection1\n" +
                "\t{page:WordSection1;}\n" +
                "-->\n" +
                "</style>\n" +
                "<!--[if gte mso 10]>\n" +
                "<style>\n" +
                " /* Style Definitions */\n" +
                " table.MsoNormalTable\n" +
                "\t{mso-style-name:普通表格;\n" +
                "\tmso-tstyle-rowband-size:0;\n" +
                "\tmso-tstyle-colband-size:0;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-priority:99;\n" +
                "\tmso-style-parent:\"\";\n" +
                "\tmso-padding-alt:0cm 5.4pt 0cm 5.4pt;\n" +
                "\tmso-para-margin:0cm;\n" +
                "\tmso-para-margin-bottom:.0001pt;\n" +
                "\tmso-pagination:widow-orphan;\n" +
                "\tfont-size:10.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                "</style>\n" +
                "<![endif]--><!--[if gte mso 9]><xml>\n" +
                " <o:shapedefaults v:ext=\"edit\" spidmax=\"1026\"/>\n" +
                "</xml><![endif]--><!--[if gte mso 9]><xml>\n" +
                " <o:shapelayout v:ext=\"edit\">\n" +
                "  <o:idmap v:ext=\"edit\" data=\"1\"/>\n" +
                " </o:shapelayout></xml><![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "<body lang=ZH-CN link=\"#0563C1\" vlink=\"#954F72\" style='tab-interval:21.0pt;\n" +
                "text-justify-trim:punctuation'>\n" +
                "\n" +
                "<div class=WordSection1>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"微软雅黑\",sans-serif'>尊敬的用户您好，<span\n" +
                "lang=EN-US><o:p></o:p></span></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"微软雅黑\",sans-serif'>您在财务共享系统中如下月结工单已超<span\n" +
                "lang=EN-US>4</span>小时未审批，为避免影响月结进度，<b><span style='color:red'>系统已自动审批通过</span></b>，请及时登录系统（<span\n" +
                "lang=EN-US><a href=\"https://fssc.anta.com/\">https://fssc.anta.com/</a></span>）进行审核，如需调整审核结果，请及时联系提单人或本单业财审核人员沟通，\n" +
                "如未反馈，视同已审批确认，谢谢！<span lang=EN-US><o:p></o:p></span></span></p>\n" +
                "\n" +
                "<table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width=1299\n" +
                " style='width:974.0pt;margin-left:-.15pt;border-collapse:collapse;mso-yfti-tbllook:\n" +
                " 1184;mso-padding-alt:0cm 0cm 0cm 0cm'>\n" +
                " <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;height:15.0pt'>\n" +
                "  <td width=141 nowrap style='width:106.1pt;border:solid windowtext 1.0pt;\n" +
                "  background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>单据名称<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=147 nowrap style='width:109.9pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>单据编号<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=161 nowrap style='width:121.0pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>提单人<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=161 nowrap style='width:121.0pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>到达待办时间<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=112 style='width:84.0pt;border:solid windowtext 1.0pt;border-left:\n" +
                "  none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>金额合计<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=187 nowrap style='width:140.0pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>业务类型<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=389 nowrap style='width:292.0pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>标题<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                " </tr>" +
                // 单据信息
                lineContentBuilder +
                " </table>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US style='font-family:\"微软雅黑\",sans-serif'><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"微软雅黑\",sans-serif'>本邮件属系统邮件，请勿回复，有任何问题请联系\n" +
                "<span lang=EN-US><a href=\"mailto:fssc@anta.com\">fssc@anta.com</a></span>，感谢您的合作！<span\n" +
                "lang=EN-US><o:p></o:p></span></span></p>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";
    }


    /**
     * 生成报销费用欠票提醒邮件内容
     * @return
     */
    public static String generateBeforehandSendMailContent(List<TaskForcedEndVo> taskForcedEndList) {
        // 单据信息行
        StringBuilder lineContentBuilder = new StringBuilder();
            for (TaskForcedEndVo taskForcedEndVo  : taskForcedEndList) {
            lineContentBuilder.append(generateBookLineContent(taskForcedEndVo));
        }

        // 邮件内容
        return "<html xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
                "xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "xmlns:x=\"urn:schemas-microsoft-com:office:excel\"\n" +
                "xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\"\n" +
                "xmlns=\"http://www.w3.org/TR/REC-html40\">\n" +
                "\n" +
                "<head>\n" +
                "<meta http-equiv=Content-Type content=\"text/html; charset=unicode\">\n" +
                "<meta name=ProgId content=Word.Document>\n" +
                "<meta name=Generator content=\"Microsoft Word 15\">\n" +
                "<meta name=Originator content=\"Microsoft Word 15\">\n" +
                "<style>\n" +
                "<!--\n" +
                " /* Font Definitions */\n" +
                " @font-face\n" +
                "\t{font-family:宋体;\n" +
                "\tpanose-1:2 1 6 0 3 1 1 1 1 1;\n" +
                "\tmso-font-alt:SimSun;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:auto;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:3 680460288 22 0 262145 0;}\n" +
                "@font-face\n" +
                "\t{font-family:\"Cambria Math\";\n" +
                "\tpanose-1:2 4 5 3 5 4 6 3 2 4;\n" +
                "\tmso-font-charset:1;\n" +
                "\tmso-generic-font-family:roman;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:0 0 0 0 0 0;}\n" +
                "@font-face\n" +
                "\t{font-family:等线;\n" +
                "\tpanose-1:2 1 6 0 3 1 1 1 1 1;\n" +
                "\tmso-font-alt:DengXian;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:auto;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:-1610612033 953122042 22 0 262159 0;}\n" +
                "@font-face\n" +
                "\t{font-family:微软雅黑;\n" +
                "\tpanose-1:2 11 5 3 2 2 4 2 2 4;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:swiss;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:-2147483001 718224464 22 0 262175 0;}\n" +
                "@font-face\n" +
                "\t{font-family:\"\\@等线\";\n" +
                "\tpanose-1:2 1 6 0 3 1 1 1 1 1;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:auto;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:-1610612033 953122042 22 0 262159 0;}\n" +
                "@font-face\n" +
                "\t{font-family:\"\\@宋体\";\n" +
                "\tpanose-1:2 1 6 0 3 1 1 1 1 1;\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:auto;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:3 680460288 22 0 262145 0;}\n" +
                "@font-face\n" +
                "\t{font-family:\"\\@微软雅黑\";\n" +
                "\tmso-font-charset:134;\n" +
                "\tmso-generic-font-family:swiss;\n" +
                "\tmso-font-pitch:variable;\n" +
                "\tmso-font-signature:-2147483001 718224464 22 0 262175 0;}\n" +
                " /* Style Definitions */\n" +
                " p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
                "\t{mso-style-unhide:no;\n" +
                "\tmso-style-qformat:yes;\n" +
                "\tmso-style-parent:\"\";\n" +
                "\tmargin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\ttext-align:justify;\n" +
                "\tmso-pagination:widow-orphan;\n" +
                "\tfont-size:10.5pt;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-bidi-font-family:宋体;}\n" +
                "a:link, span.MsoHyperlink\n" +
                "\t{mso-style-noshow:yes;\n" +
                "\tmso-style-priority:99;\n" +
                "\tcolor:#0563C1;\n" +
                "\ttext-decoration:underline;\n" +
                "\ttext-underline:single;}\n" +
                "a:visited, span.MsoHyperlinkFollowed\n" +
                "\t{mso-style-noshow:yes;\n" +
                "\tmso-style-priority:99;\n" +
                "\tcolor:#954F72;\n" +
                "\ttext-decoration:underline;\n" +
                "\ttext-underline:single;}\n" +
                "p.msonormal0, li.msonormal0, div.msonormal0\n" +
                "\t{mso-style-name:msonormal;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tmso-margin-top-alt:auto;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmso-margin-bottom-alt:auto;\n" +
                "\tmargin-left:0cm;\n" +
                "\tmso-pagination:widow-orphan;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:宋体;\n" +
                "\tmso-bidi-font-family:宋体;}\n" +
                "span.EmailStyle18\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle19\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle20\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle21\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle22\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle23\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle24\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle25\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle26\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle27\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                "span.EmailStyle28\n" +
                "\t{mso-style-type:personal;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-unhide:no;\n" +
                "\tfont-family:等线;\n" +
                "\tmso-ascii-font-family:等线;\n" +
                "\tmso-fareast-font-family:等线;\n" +
                "\tmso-hansi-font-family:等线;\n" +
                "\tcolor:windowtext;}\n" +
                ".MsoChpDefault\n" +
                "\t{mso-style-type:export-only;\n" +
                "\tmso-default-props:yes;\n" +
                "\tfont-size:10.0pt;\n" +
                "\tmso-ansi-font-size:10.0pt;\n" +
                "\tmso-bidi-font-size:10.0pt;\n" +
                "\tmso-ascii-font-family:\"Times New Roman\";\n" +
                "\tmso-fareast-font-family:\"Times New Roman\";\n" +
                "\tmso-hansi-font-family:\"Times New Roman\";\n" +
                "\tmso-font-kerning:0pt;}\n" +
                "@page WordSection1\n" +
                "\t{size:612.0pt 792.0pt;\n" +
                "\tmargin:72.0pt 90.0pt 72.0pt 90.0pt;\n" +
                "\tmso-header-margin:36.0pt;\n" +
                "\tmso-footer-margin:36.0pt;\n" +
                "\tmso-paper-source:0;}\n" +
                "div.WordSection1\n" +
                "\t{page:WordSection1;}\n" +
                "-->\n" +
                "</style>\n" +
                "<!--[if gte mso 10]>\n" +
                "<style>\n" +
                " /* Style Definitions */\n" +
                " table.MsoNormalTable\n" +
                "\t{mso-style-name:普通表格;\n" +
                "\tmso-tstyle-rowband-size:0;\n" +
                "\tmso-tstyle-colband-size:0;\n" +
                "\tmso-style-noshow:yes;\n" +
                "\tmso-style-priority:99;\n" +
                "\tmso-style-parent:\"\";\n" +
                "\tmso-padding-alt:0cm 5.4pt 0cm 5.4pt;\n" +
                "\tmso-para-margin:0cm;\n" +
                "\tmso-para-margin-bottom:.0001pt;\n" +
                "\tmso-pagination:widow-orphan;\n" +
                "\tfont-size:10.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                "</style>\n" +
                "<![endif]--><!--[if gte mso 9]><xml>\n" +
                " <o:shapedefaults v:ext=\"edit\" spidmax=\"1026\"/>\n" +
                "</xml><![endif]--><!--[if gte mso 9]><xml>\n" +
                " <o:shapelayout v:ext=\"edit\">\n" +
                "  <o:idmap v:ext=\"edit\" data=\"1\"/>\n" +
                " </o:shapelayout></xml><![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "<body lang=ZH-CN link=\"#0563C1\" vlink=\"#954F72\" style='tab-interval:21.0pt;\n" +
                "text-justify-trim:punctuation'>\n" +
                "\n" +
                "<div class=WordSection1>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal align=left style='text-align:left'><span style='font-family:\n" +
                "\"微软雅黑\",sans-serif'>尊敬的用户您好，</span><span lang=EN-US style='font-size:11.0pt'><o:p></o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US style='font-family:\"微软雅黑\",sans-serif'><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"微软雅黑\",sans-serif'>您在财务共享当前共有<span\n" +
                "lang=EN-US>2</span>条<span style='color:red'>月结待办</span>工单，请及时登录财务共享平台<span\n" +
                "lang=EN-US><a href=\"https://fssc.anta.com/\">https://fssc.anta.com/</a> </span>或\n" +
                "智行安踏<span lang=EN-US>APP-</span>财务共享进行处理！<span lang=EN-US><o:p></o:p></span></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"微软雅黑\",sans-serif'>为满足月结时效要求，<span\n" +
                "style='color:red'>月结期间</span>工单在本环节的审批等待时长为<span lang=EN-US>4</span>小时（<span\n" +
                "lang=EN-US>8</span>：<span lang=EN-US>00-20</span>：<span lang=EN-US>00</span>内），如您未及时审核处理，工单将在超<span\n" +
                "lang=EN-US>4</span>小时等待后<b><span style='color:red'>自动通过本环节审批</span></b>，流转至下一环节！<span\n" +
                "lang=EN-US><o:p></o:p></span></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"微软雅黑\",sans-serif'>明细如下：<span\n" +
                "lang=EN-US><o:p></o:p></span></span></p>\n" +
                "\n" +
                "<table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width=1299\n" +
                " style='width:974.0pt;margin-left:-.15pt;border-collapse:collapse;mso-yfti-tbllook:\n" +
                " 1184;mso-padding-alt:0cm 0cm 0cm 0cm'>\n" +
                " <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;height:15.0pt'>\n" +
                "  <td width=151 nowrap style='width:113.15pt;border:solid windowtext 1.0pt;\n" +
                "  background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>单据名称<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=137 nowrap style='width:102.85pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>单据编号<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=161 nowrap style='width:121.0pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>提单人<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=161 nowrap style='width:121.0pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>到达待办时间<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=112 style='width:84.0pt;border:solid windowtext 1.0pt;border-left:\n" +
                "  none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>金额合计<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=187 nowrap style='width:140.0pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>业务类型<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                "  <td width=389 nowrap style='width:292.0pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;background:#C00000;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><b><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:white'>标题<span lang=EN-US><o:p></o:p></span></span></b></p>\n" +
                "  </td>\n" +
                " </tr>" +
                // 单据信息
                lineContentBuilder +
                " </table>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US style='font-family:\"微软雅黑\",sans-serif'><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"微软雅黑\",sans-serif'>本邮件属系统邮件，请勿回复，有任何问题请联系\n" +
                "<span lang=EN-US><a href=\"mailto:fssc@anta.com\">fssc@anta.com</a></span>，感谢您的合作！<span\n" +
                "lang=EN-US><o:p></o:p></span></span></p>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";
    }


    /**
     *  单行单据生成
     * @return
     */
    private static String generateBookLineContent(TaskForcedEndVo taskForcedEndVo) {
        return " <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes;height:16.5pt'>\n" +
                "  <td width=141 nowrap style='width:106.1pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:16.5pt'>\n" +
                "  <p class=MsoNormal align=left style='text-align:left'><span lang=EN-US\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:black'>"+taskForcedEndVo.getBoName()+"<span lang=EN-US><o:p></o:p></span></span></p>\n" +
                "  </td>\n" +
                "  <td width=147 nowrap style='width:109.9pt;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:16.5pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><span lang=EN-US\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:black'>"+taskForcedEndVo.getBono()+"<o:p></o:p></span></p>\n" +
                "  </td>\n" +
                "  <td width=161 nowrap style='width:121.0pt;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:16.5pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><span\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:black'>"+taskForcedEndVo.getAppLicant()+"<o:p></o:p></span></span></p>\n" +
                "  </td>\n" +
                "  <td width=161 nowrap style='width:121.0pt;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:16.5pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><span lang=EN-US\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:black'>"+taskForcedEndVo.getCreateTime()+"<o:p></o:p></span></p>\n" +
                "  </td>\n" +
                "  <td width=112 style='width:84.0pt;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:16.5pt'>\n" +
                "  <p class=MsoNormal align=center style='text-align:center'><span lang=EN-US\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:black'>"+taskForcedEndVo.getOriginalamount()+"<o:p></o:p></span></p>\n" +
                "  </td>\n" +
                "  <td width=187 nowrap style='width:140.0pt;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:16.5pt'>\n" +
                "  <p class=MsoNormal align=left style='text-align:left'><span style='font-family:\n" +
                "  \"微软雅黑\",sans-serif;color:black'>"+taskForcedEndVo.getBusinessType()+"<o:p></o:p></span></span></p>\n" +
                "  </td>\n" +
                "  <td width=389 nowrap style='width:292.0pt;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:16.5pt'>\n" +
                "  <p class=MsoNormal align=left style='text-align:left'><span lang=EN-US\n" +
                "  style='font-family:\"微软雅黑\",sans-serif;color:black'>"+taskForcedEndVo.getTitle()+"<o:p></o:p></span></span></p>\n" +
                "  </td>\n" +
                " </tr>";
    }


}





package com.epoch.workflow.vo;

public class TaskForcedEndVo {
    private Long  taskId;
    private String  createTime;
    private String  boName;
    private String  bono;
    private String  appLicant;
    private String originalamount;
    private String  businessType;
    private String  title;
    private String  email;
    private String  actorId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBoName() {
        return boName;
    }

    public void setBoName(String boName) {
        this.boName = boName;
    }

    public String getBono() {
        return bono;
    }

    public void setBono(String bono) {
        this.bono = bono;
    }

    public String getAppLicant() {
        return appLicant;
    }

    public void setAppLicant(String appLicant) {
        this.appLicant = appLicant;
    }

    public String getOriginalamount() {
        return originalamount;
    }

    public void setOriginalamount(String originalamount) {
        this.originalamount = originalamount;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }
}

http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=5d6334312406ed987cae291f433053564c56500555010155514e0409535349505150511c050856574e0055015d545c555656070557306c64020d40504a470516635d&code=cc41d0dd&fid=72/5d411e12-087c-423e-a823-ca09d8155343&fid=72/5d411e12-087c-423e-a823-ca09d8155343

http://mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftn_download&k=5a373436f80eb99d7bfa2918443807534b030207065b5602051a0c015a0e1d5552040c1b5a09515249035757500106510507015406383861055940574d4f51136409&code=d746c80a&fid=72/461ecfca-8796-4638-91a3-4ca3960a05be&fid=72/461ecfca-8796-4638-91a3-4ca3960a05be
