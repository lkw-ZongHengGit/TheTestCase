# TheTestCase


gmall-user :ÓÃ»§·þÎñ,¶Ë¿Ú8080

分支：test

测试,增加job1



mapper层的方法：



 @Override
    @Transactional(rollbackFor=Exception.class)
    public void synTaxSuject(List<AfilOptionsTaxpayerDTO> pushDTO) {
        if (CollectionUtils.isEmpty(pushDTO)) {
            return;
        }
       /*
        代码逻辑：
       * 1）、遍历税务系统传来的数据，拿到纳税主体id以及印花税id
       * 2）、根据id删除数据
       * 3）、再将税务系统传来的数据重新插入
       * */
        List<String> itemIdList = new ArrayList<>();
        List<String> taxpayerIds = new ArrayList<>();
        List<StampdutyItemDTO> list = new ArrayList<>();
        List<AfilOptionsTaxpayer> afilOptionsTaxpayerList = pushDTO.stream().map(custDto -> {
            AfilOptionsTaxpayer afilOptionsTaxpayer = new AfilOptionsTaxpayer();
            //获取纳税主体关联的印花税
            List<StampdutyItemDTO> stampdutyItemDTo = custDto.getStampdutyItemDTo();
            //收集纳税主体id，后边根据id统一删除
            taxpayerIds.add(custDto.getId());
            if (!CollectionUtils.isEmpty(stampdutyItemDTo)) {
                for (StampdutyItemDTO stampdutyItemDTO : stampdutyItemDTo) {
                    //收集印花税id以及印花税实体类，方便后边删除以及插入
                    list.add(stampdutyItemDTO);
                    itemIdList.add(stampdutyItemDTO.getId());
                }
            }
            BeanUtils.copyProperties(custDto, afilOptionsTaxpayer);
            return afilOptionsTaxpayer;
        }).collect(Collectors.toList());
        //删除纳税主体、印花税
        afilOptionsTaxpayerMapper.deleteAfilOptionsTaxpayerByIds(taxpayerIds.toArray(new String[]{}));
        iAfilOptionsTaxpayerStampdutyItemService.deleteAfilOptionsTaxpayerStampdutyItemByIds(itemIdList.toArray(new String[]{}));
        //新增纳税主体、印花税
        iAfilOptionsTaxpayerStampdutyItemService.insertBatch(list);
        afilOptionsTaxpayerMapper.insertBatch(afilOptionsTaxpayerList);
    }


    /**
     * 批量删除纳税主体关联印花税数目
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAfilOptionsTaxpayerStampdutyItemByIds(String[] ids);


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



业务逻辑：注意@Transactional(rollbackFor=Exception.class) 事务的正确做法

taxpayerIds.toArray(new String[]{})   list转array


