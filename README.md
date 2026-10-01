2026-09-30 18:35:35.775 DEBUG http-nio-8080-exec-7 -[6abce5f50000000067cd33a3bdd98a2b]-[python anta] c.p.v.s.d.P.updateEnd                         : ==> Parameters: [PID:79697][I 2026-09-30 18:35:35 element:577] Generate journal sb_ids: [1, 3]
<'SOB_id': 1
Journal_Error_0: journal_mapping表配置不完整 | 定位:
   journal_type         account_type_code
12          SW1  accumulated_depreciation
13          SW1       lease_liability_adj
14          SW1      lease_liability_cost
15          SW1         transfer_internal
16          SW1         usage_right_asset
[PID:79697][E 2026-09-30 18:35:35 standard_enter:295] CFRCAIBEHFRJ0035161 : ERROR!!!
Traceback (most recent call last):
  File "/home/admin/pythonfile/tcanta/app1/action/standard_enter.py", line 289, in contract_journal_155
journal_id_str = jn.contract_journal_main(sc['year'], sc['period'])  # 生成凭证返回凭证号列表
  File "/home/admin/pythonfile/tcanta/app1/lease_contract/cls_journal/journal_models/contract_gene_journal.py", line 128, in contract_journal_main
    journal_head, journal_line = SYSINFO_JN.get_journal(journal_raw_data, each_sob, year, period, self.cfg_lst)
  File "/home/puser/pythonfile/tcc0000init/app1/common/journal.py", line 121, in get_journal
common.journal.JournalError: Journal_Error_0: journal_mapping表配置不完整 | 定位:
   journal_type         account_type_code
12          SW1  accumulated_depreciation
13          SW1       lease_liability_adj
14          SW1      lease_liability_cost
15          SW1         transfer_internal
16          SW1         usage_right_asset
(String), (String), 2026-09-30 18:35:35.774(Timestamp), 512006(Integer)
