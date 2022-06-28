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



http://mail.qq.com/cgi-bin/ftnExs_download?k=0a326265f353eace2bff7f4b136654001b075a5003070150561f500307054e06000056485502550a19035456025200025607505105666b32555c16041a110240340c&t=exs_ftn_download&code=42be4fc2&fid=72/5857abbb-2f3c-4424-ad68-16364c0b5241
