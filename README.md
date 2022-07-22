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
