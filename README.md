# TheTestCase


gmall-user :ÓÃ»§·þÎñ,¶Ë¿Ú8080

分支：test

测试,增加job1



7.2 报文定义
接口请求地址（测试)：
POST： 
测试环境：https://192.168.91.19/anta/contract/constructUrl
生产环境：https://192.168.66.71/anta/contract/constructUrl



	<dependency>
			<groupId>commons-httpclient</groupId>
			<artifactId>commons-httpclient</artifactId>
			<version>3.1</version>
		</dependency>
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient-cache</artifactId>
			<version>4.5.3</version>
		</dependency>
		<dependency>
			<groupId>com.metaparadigm</groupId>
			<artifactId>json-rpc</artifactId>
			<version>1.0</version>
		</dependency>
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.1.41</version>
		</dependency>








<resultMap type="com.tax.option.dto.taxpayer.TaxpayerPushCustDTo" id="TaxPayerPushResult">
        <id column="ID" property="id" jdbcType="VARCHAR"/>
        <result column="IS_ENABLE" property="isEnable" jdbcType="INTEGER"/>
        <result column="IS_DELETE" property="isDelete" jdbcType="INTEGER"/>
        <result column="TAXPAYER_NO" property="taxpayerNo" jdbcType="VARCHAR"/>
        <result column="TAXPAYER_NAME" property="taxpayerName" jdbcType="VARCHAR"/>
        <result column="CORPORATE_HIERARCHY" property="corporateHierarchy" jdbcType="INTEGER"/>
        <result column="REGISTER_PROVINCE" property="registerProvince" jdbcType="VARCHAR"/>
        <result column="REGISTER_CITY" property="registerCity" jdbcType="VARCHAR"/>
        <result column="REGISTER_DISTRICT" property="registerDistrict" jdbcType="VARCHAR"/>
        <result column="ACCOUNTING_TYPE" property="accountingType" jdbcType="INTEGER"/>
        <result column="REGISTER_POSTAL_CODE" property="registerPostalCode" jdbcType="VARCHAR"/>
        <result column="VAT_TAXPAYER_IDENTITY" property="vatTaxpayerIdentity" jdbcType="INTEGER"/>
        <collection  property="stampdutyItemDTo"   javaType="java.util.List"   resultMap="TaxPayerPushChildrenResult" />
    </resultMap>

    <resultMap type="com.tax.option.dto.taxpayer.StampdutyItemDTo" id="TaxPayerPushChildrenResult">
        <id column="ITEM_ID" property="id" jdbcType="VARCHAR"/>
        <result column="AUTHORIZED_LEVY" property="authorizedLevy" jdbcType="VARCHAR" />
        <result column="AUTHORIZED_RATIO" property="authorizedRatio" jdbcType="DECIMAL" />
        <result column="CREATE_XML_QUANTITY" property="createXmlQuantity" jdbcType="INTEGER"/>
        <result column="TAXPAYER_ID" property="taxpayerId" jdbcType="VARCHAR" />
        <result column="ITEM_IS_ENABLE" property="isEnable" jdbcType="INTEGER"/>
        <result column="ITEM_IS_DELETE" property="isDelete" jdbcType="INTEGER"/>
    </resultMap>
    
    response拿回到的数据怎么进行转换成String；
           HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
    
    将String类型大json字符串转map的工具类：
    
      Map result = JSONObject.parseObject(body, Map.class);
    
