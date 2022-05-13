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
    
    
    maper.xml写法：


    <delete id="deleteAfilOptionsTaxpayerStampdutyItemByIds" parameterType="String">
        delete from afil_options_taxpayer_stampduty_item where id in 
        <foreach item="id" collection="array" open="(" separator="," close=")">
            #{id}
        </foreach>
    </delete>

    <insert id="insertBatch" parameterType="java.util.List" >
        insert into afil_options_taxpayer_stampduty_item (id,del_flag,status,create_time,authorized_levy,authorized_ratio,create_xml_quantity,taxpayer_id) VALUES
        <foreach collection="list" index="index" item="item" separator="," >
            (#{item.id},#{item.delFlag},#{item.status},now(),#{item.authorizedLevy},#{item.authorizedRatio},#{item.createXmlQuantity},#{item.taxpayerId})
        </foreach>
    </insert>



    String filePath = "tax/2022/05/07/AT销项发票汇总底稿.xlsx";
        //查看下标最后一次 / 出现的下标  ：  14
        int i = filePath.lastIndexOf("/");
        System.out.println(i);
        // 从最后一个“/”出现的下标+1开始截取，得到：AT销项发票汇总底稿.xlsx
        String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
        System.out.println(substring);
        //从第一个下标截取，一直到“/”出现的下标+1，得到：   tax/2022/05/07/
        String substring1 = filePath.substring(0, filePath.lastIndexOf("/")+1);
        System.out.println(substring1);
        // 匹配字符串以某个英文字母开头
        boolean tax = filePath.startsWith("tax");
        System.out.println(tax);




							   
