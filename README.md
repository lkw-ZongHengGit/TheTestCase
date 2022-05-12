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



  这几天我认真想了想，真的如我所说是始于颜值吗？如果仅仅因为你长的好看，根本不能让我如此上心，被你一再拒绝的日子里我也坚持不下去。我很了解我，单凭长相把我迷得死去活来的人不可能存在，因为本质上我是一个理性的人。我有着成熟的三观，有着一套自我保护的标准，也有自己的傲慢，更重要的我是个自由的灵魂。可这次灵魂像是被抽走，傲慢像是被剥离，向你低头，仅仅因为颜值？最后我否定了这个答案。可到底是什么呢？我一连想了好几天，百思不得解。或许是今天的雨带给了我灵感，我终于想通了，是你身上有种独特的气质在吸引我，吸引我一直想要了解你。我开始尝试回忆我们初次见面，那是我去心理协会面试，你及另外两人是考官。我当时边介绍自己，边望向你们，目光转到你时你正低头看着资料，不过还是被我瞧出来很漂亮。接着介绍完，你们问了我一些问题，我一一回答。到你问时，你语气上比较暖，却始终不苟言笑，给人一种冷漠里又透着善意的感觉，很矛盾。我现在想到的词汇去形容就是：一半像海水，一半像火焰。想去了解你的种子从那时就种下了。之后跟你接触几次，你的态度始终都是这样，没有因为我们进入心理协会而改变，即便站在一起也觉得难以接近，换做其他人，总会佯装一下热情，你却没有，甚至没有太多攀谈。后来因为竞选班长遇到的龌龊事，打散了我很多积极性，对社团的事也不再上心了。不去社团后，见你次数最多的就是在餐厅了，你总是跟一位个子比较高的女同学一起，有时买完饭便匆匆离去，我有几次看着你渐行渐远的背影，眉头都皱起来了，真让人看不透，神神秘秘，却又那么吸引我，真是独特的人儿。我不知道在你认知里，两人熟悉到何种程度才能谈喜欢二字。在我观念里，当想要去了解一个人时，已经可以谈喜欢了。你像是藏着很多故事的小说家，我则像一位渴望挖出这些故事的好事者，对你充满好奇。那种感觉一直伴随着我，令我难忘，始终记得有个特别的姑娘。
							   
