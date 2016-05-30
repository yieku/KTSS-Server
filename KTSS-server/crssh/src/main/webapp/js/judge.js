/**
 * 
 */


//检测用户类别
function check()
{
	
	
	var nu = document.getElementById("selectId").options[window.document.getElementById("selectId").selectedIndex].value;
	if(nu=="1")
	{
		window.location.href="farm_register.jsp"; 
	}
	else if(nu=="2")
	{
		window.location.href="expert_register.jsp";
	}
	
}


//将所有请求以post方式提交










