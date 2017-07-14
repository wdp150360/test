USE [zb_marketing]
GO
/****** Object:  StoredProcedure [dbo].[P_bi_channel_day_f]    Script Date: 2017/1/11 星期三 下午 2:55:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
ALTER PROCEDURE [dbo].[P_bi_channel_day_f]
-- Add the parameters for the stored procedure here
	@platformid varchar(10),---平台ID(0、唐小僧,1、摇旺)
	@yyyymmdd [varchar](12) ,---日期
	@Register_dt_start	[varchar](12) ,---注册日期起始日期
	@Register_dt_end	[varchar](12) ,---注册日期结束日期
	@channeltype [nvarchar](255) ,---渠道分类
	@Referralsource	varchar(50)　---推荐来源(本体　、裂变渠道)

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	declare
	@date_b date , ---开始日期
	@date_e date , ---结束日期
	@date_e1 date,
	@acc_in_num	int,
	@days decimal(18,2);
	set @date_b=left(CONVERT(varchar(12) , dateadd(day,-1,getdate()), 120 ) ,10);
	set @date_e=left(CONVERT(varchar(12) , dateadd(day,-1,getdate()), 120 ) ,10);
	set @date_e1=dateadd(day,1,@Register_dt_end);
	set @days=DATEDIFF( day, @date_b, @date_e)+1;

	if  @channeltype='全部' and @platformid = '0'

		BEGIN
			-- Insert statements for procedure here
			select t1.accountid into #accountid from bi_staging.dbo.accountinfo t1
			where t1.created>=@Register_dt_start and t1.created<@date_e1


			select @acc_in_num = count(distinct t1.accountid) from #accountid t1

			SELECT   b.[RecordDate] ,sum(b.[DemandAmount]) + sum(b.[FixedAmount]) amount,count(distinct b.[AccountID]) acc_num
			into #In_cast
			FROM  [BI_Staging].[dbo].[dailyinvestrecord] b
			where	b.[IsDataAvailable] = 1 and b.[DemandAmount] + b.[FixedAmount] > 5
						 and exists (select 1 from #accountid a where a.accountid = b.accountid)
			group by b.[RecordDate]

			select distinct    t1.yyyymmdd, sum(amount) over (order by yyyymmdd) as investamount
			into #investment1
			from zb_marketing.[dbo].[bi_investment_f] t1 (nolock)
			where   yyyymmdd<=@yyyymmdd and yyyymmdd >= dateadd(day,-6 ,@yyyymmdd) and platformid =@platformid
							and exists (select 1 from #accountid a where a.accountid = t1.accountid)


			select b.[RecordDate] as yyyymmdd,b.amount as Oninvestamount,b.acc_num as Oninvestcount,b.amount /a.investamount as Rate_retention
				,b.acc_num/@acc_in_num as Retained_customer_rate
			from #In_cast as b  inner join #investment1 a on b.RecordDate = a.yyyymmdd
			order by b.RecordDate desc

		END
	else	if  @channeltype='全部' and @platformid = '1'
		BEGIN
			set @acc_in_num = 0

			select t1.customer_id into #accountid_YW from zb_marketing.dbo.stg_yw_tb_customer_login t1
			where t1.[register_time]>=@Register_dt_start and t1.[register_time]<@date_e1


			select @acc_in_num = count(distinct t1.customer_id) from #accountid_YW t1

			SELECT   b.[dateid] ,sum(b.[DemandAmount]) + sum(b.[FixedAmount]) amount,count(distinct b.[AccountID]) acc_num
			into #In_cast_yw
			FROM  zb_marketing.[dbo].[STG_YW_DAILYINVESTRECORD] b
			where	  b.[DemandAmount] + b.[FixedAmount] > 5
							 and exists (select 1 from #accountid a where a.accountid = b.accountid)
			group by b.[dateid]

			select distinct    t1.yyyymmdd, sum(amount) over (order by yyyymmdd) as investamount
			into #investment_yw
			from zb_marketing.[dbo].[bi_investment_f] t1 (nolock)
			where   yyyymmdd<=@yyyymmdd and yyyymmdd >= dateadd(day,-6,@yyyymmdd) and platformid =@platformid
							and exists (select 1 from #accountid a where a.accountid = t1.accountid)

			select b.[dateid] as yyyymmdd,b.amount as Oninvestamount,b.acc_num as Oninvestcount,b.amount /a.investamount as Rate_retention
				,b.acc_num/@acc_in_num as Retained_customer_rate
			from #In_cast_yw as b  inner join #investment_yw a on b.RecordDate = a.yyyymmdd
			order by b.RecordDate desc
		END


	else if  @channeltype <> '全部' and @platformid = '0'

		BEGIN
			-- Insert statements for procedure here
			select t1.accountid into #accountid1 from bi_staging.dbo.accountinfo t1
				inner join bi_staging.dbo.channel t2
					on t1.channel = t2.code
			where t1.created>=@Register_dt_start and t1.created<@date_e1
						and t2.title  = @channeltype


			select @acc_in_num = count(distinct t1.accountid) from #accountid1 t1

			SELECT   b.[RecordDate] ,sum(b.[DemandAmount]) + sum(b.[FixedAmount]) amount,count(distinct b.[AccountID]) acc_num
			into #In_cast1
			FROM  [BI_Staging].[dbo].[dailyinvestrecord] b
			where	b.[IsDataAvailable] = 1 and b.[DemandAmount] + b.[FixedAmount] > 5
						 and exists (select 1 from #accountid1 a where a.accountid = b.accountid)
			group by b.[RecordDate]

			select  distinct    t1.yyyymmdd, sum(amount) over (order by yyyymmdd) as investamount
			into #investment11
			from zb_marketing.[dbo].[bi_investment_f] t1 (nolock)
			where   yyyymmdd<=@yyyymmdd and yyyymmdd >= dateadd(day,-6,@yyyymmdd) and
							platformid =@platformid
							and exists (select 1 from #accountid1 a where a.accountid = t1.accountid)



			select b.[RecordDate] as yyyymmdd,b.amount as Oninvestamount,b.acc_num as Oninvestcount,b.amount /a.investamount as Rate_retention
				,b.acc_num/@acc_in_num as Retained_customer_rate
			from #In_cast1 as b  inner join #investment11 a on b.RecordDate = a.yyyymmdd
			order by b.RecordDate desc

		END
	else	if  @channeltype <> '全部' and @platformid = '1'
		BEGIN
			set @acc_in_num = 0

			select t1.customer_id into #accountid_YW1 from zb_marketing.dbo.stg_yw_tb_customer_login t1
			where t1.[register_time]>=@Register_dt_start and t1.[register_time]<@date_e1
						and t1.channel  = @channeltype

			select @acc_in_num = count(distinct t1.customer_id) from #accountid_YW1 t1

			SELECT   b.[dateid] ,sum(b.[DemandAmount]) + sum(b.[FixedAmount]) amount,count(distinct b.[AccountID]) acc_num
			into #In_cast_yw1
			FROM  zb_marketing.[dbo].[STG_YW_DAILYINVESTRECORD] b
			where	  b.[DemandAmount] + b.[FixedAmount] > 5
							 and exists (select 1 from #accountid_YW1 a where a.accountid = b.accountid)
			group by b.[dateid]

			select distinct    t1.yyyymmdd, sum(amount) over (order by yyyymmdd) as investamount
			into #investment_yw1
			from zb_marketing.[dbo].[bi_investment_f] t1 (nolock)
			where   yyyymmdd<=@yyyymmdd and yyyymmdd >= dateadd(day,-6,@yyyymmdd) and platformid =@platformid
							and exists (select 1 from #accountid_YW1 a where a.accountid = t1.accountid)

			select b.[dateid] as yyyymmdd,b.amount as Oninvestamount,b.acc_num as Oninvestcount,b.amount /a.investamount as Rate_retention
				,b.acc_num/@acc_in_num as Retained_customer_rate
			from #In_cast_yw1 as b  inner join #investment_yw1 a on b.RecordDate = a.yyyymmdd
			order by b.RecordDate desc
		END
END
