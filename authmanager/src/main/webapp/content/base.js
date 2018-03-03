function returnurl() {
	window.history.back();location.reload(); 
}
function loadpagination(bindid,totalcount,pagesize,pageindex,paramstr)
{
	if(paramstr==undefined)
	{
		paramstr='';
	}
	if(pagesize<1)
	{
		pagesize=10;
	}
	if(pageindex!=undefined&&pageindex<1)
	{
		pageindex=1;
	}
	var pagenumend=parseInt(totalcount>0?(totalcount/pagesize+(totalcount%pagesize>0?1:0)):1);
	var pagenumprev=pageindex>0?pageindex-1:1;
	var pagenumnext=(pageindex+1)>=pagenumend?pagenumend:(pageindex+1);
	var resultstr="";
	resultstr+="<ul class='pagination'>									";
	resultstr+="<li class='previous disabled'><a>"+totalcount+"条记录 "+pageindex+"/"+pagenumend+"页</a></li>  ";
	resultstr+="  <li><a href='"+getcomplateurl(paramstr,pagesize,1)+"'>首页</a></li>                           ";
	resultstr+="  <li><a href='"+getcomplateurl(paramstr,pagesize,pagenumprev)+"'>上一页</a></li>               ";
	resultstr+="  <li class='active'><a>"+pageindex+"</a></li>               ";
	resultstr+="  <li><a href='"+getcomplateurl(paramstr,pagesize,pagenumnext)+"'>下一页</a></li>               ";
	resultstr+="  <li><a href='"+getcomplateurl(paramstr,pagesize,pagenumend)+"'>尾页</a></li>                  ";
	resultstr+="</ul>                                                     ";
		
	$("#"+bindid).html(resultstr);
}
function getcomplateurl(queryparam,pagesize,pageindex)
{
	var paramstr='';
	if(queryparam!=undefined&&queryparam.length>0)
	{
		paramstr+='&'+queryparam;
	}
	if(queryparam!=undefined&&pagesize>0)
	{
		paramstr+='&pagesize='+pagesize;
	}
	if(queryparam!=undefined&&pageindex>0)
	{
		paramstr+='&pageindex='+pageindex;
	}
	
	if(paramstr.length>0)
	{
		paramstr='?'+(paramstr.indexOf('&')==0?paramstr.substr(1):paramstr);
	}
	return window.location.pathname+paramstr;
}
