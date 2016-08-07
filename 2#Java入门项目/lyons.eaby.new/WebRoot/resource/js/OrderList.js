
/**
*批量删除订单
*/
function deleteOrderBatch(basePath)
{
    $("#mainForm").attr("action",basePath+"Order.action?key=5");//临时获取值，提交给后台
    $("#mainForm").submit();
}