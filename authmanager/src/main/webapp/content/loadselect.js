function selectloaddata(datatype) {
	var datalist=null;
	var url='';
	if(datatype=="sysaction")
		{
		url="/authmanager/sysaction/selectjson";
		}
	else if(datatype=="sysmenu")
	{
	url="/authmanager/sysmenu/selectjson";
	}
	else if(datatype=="sysorg")
		{
		url="/authmanager/sysorg/selectjson";
		}
	else if(datatype=="syspermission")
	{
	url="/authmanager/syspermission/selectjson";
	}
	else if(datatype=="sysproject")
	{
	url="/authmanager/sysproject/selectjson";
	}
	else if(datatype=="sysrole")
	{
	url="/authmanager/sysrole/selectjson";
	}
	else if(datatype=="sysdic")
	{
	url="/authmanager/sysdic/selectjson";
	}
	if(url!=undefined&&url.length>0)
		{
	$.ajax({
		url :url,
		async: false,
		success : function(data) {
			if (data != undefined && data.Data != undefined
					&& data.errcode == 0) {
				datalist= data.Data;
			}
			else
				alert('获取数据异常');
		}
	});
		}
	return datalist;
}

function selectload(showdivid,datatype,inputtype,saveid,savename) {
	if($("#"+showdivid).html()=="")
	{
		var datalist=selectloaddata(datatype);
		var groupname="groupname";
		var tempcontent=selectloadchild(datalist,0,0,inputtype,groupname);
		var tempmodalid=showdivid+"_modal";
		var tempmodalbodyid=tempmodalid+"_body";
		var tempmodal="";
		tempmodal+="<div class='modal fade' id='"+tempmodalid+"' groupname='"+groupname+"' bodyid='"+tempmodalbodyid+"' saveid='"+saveid+"' savename='"+savename+"'>	";
		tempmodal+="	<div class='modal-dialog'>                                                                  ";
		tempmodal+="		<div class='modal-content'>                                                             ";
		tempmodal+="			<div class='modal-header'>                                                          ";
		tempmodal+="				<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>    ";
		tempmodal+="					&times;                                                                     ";
		tempmodal+="				</button>                                                                       ";
		tempmodal+="				<h4 class='modal-title' id='myModalLabel'>                                      ";
		tempmodal+="					选择对象                                                                    ";
		tempmodal+="				</h4>                                                                           ";
		tempmodal+="			</div>                                                                              ";
		tempmodal+="			<div class='modal-body' id='"+tempmodalbodyid+"'>                                   ";
		tempmodal+=tempcontent;
		tempmodal+="			</div>                                                                              ";
		tempmodal+="			<div class='modal-footer'>                                                          ";
		tempmodal+="			<button type='button' class='btn btn-default' data-dismiss='modal'>关闭             ";
		tempmodal+="				</button>                                                                       ";
		tempmodal+="				<button type='button' class='btn btn-primary' onclick='selectbind(\""+tempmodalid+"\");'>          ";
		tempmodal+="					确认                                                                        ";
		tempmodal+="				</button>                                                                       ";
		tempmodal+="			</div>                                                                              ";
		tempmodal+="		</div>                                                                                  ";
		tempmodal+="	</div>                                                                                      ";
		tempmodal+="</div>                                                                                       ";
		$("#"+showdivid).html(tempmodal);
	}
	selectloadvalue(saveid,tempmodalid,groupname,inputtype);
	$("#"+showdivid+"_modal").modal("show");
}
function selectloadvalue(saveid,objid,groupname,inputtype)
{
	var tempvalue=$("#"+saveid).val();
	if(tempvalue!=undefined)
	{
		if(inputtype=="radio")
		{
			$("#"+objid+" :Radio[name='"+groupname+"'][value='"+tempvalue+"']").prop("checked", "checked");
		}
		else if(inputtype=="checkbox")
		{
			var tempvaluparam= tempvalue.split(",");
			$.each(tempvaluparam, function(i, item) {
			$("#"+objid+" :checkbox[name='"+groupname+"'][value='"+item+"']").prop("checked", "checked");
			})
		}
	}
}
function selectbind(objid)
{
	var tempmodalbodyid=$("#"+objid).attr("bodyid");
	var saveid=$("#"+objid).attr("saveid");
	var savename=$("#"+objid).attr("savename");
	var groupname=$("#"+objid).attr("groupname");
	var selectitem=$('#'+objid+' input[name=\"'+groupname+'\"]:checked');
	if(selectitem!=undefined&&selectitem.length>0)
	{
		var tempid='';
		var tempname='';
		$.each(selectitem, function(i, item) {
			if(tempid.length>0)
			{
				tempid+=",";
			}
			tempid+=$(item).attr("vid");
			if(tempname.length>0)
			{
				tempname+=",";
			}
			tempname+=$(item).attr("vname");
		})
		$("#"+saveid).val(tempid);
		$("#"+savename).html(tempname);
	}
	$("#"+objid).modal("hide");
}
function selectloadchild(datalist,parentid,childnum,inputtype,groupname)
{
	var resultstr="";
	var tempdata=datalist.filter(o => o.parentid == parentid);
	if(tempdata!=undefined&&tempdata.length>0){
		$.each(tempdata, function(i, item) {
			var childstr=selectloadchild(datalist,item.id,(childnum+1),inputtype,groupname);
			var showitem={"id":item.id,"parentid":item.parentid,"name":item.name,"code":item.code,"inputtype":inputtype,"groupname":groupname,"child":childstr};
			var template1="<div style='margin-left: 10px;'><div class='checkbox'><label><input type='{inputtype}' vparentid='{parentid}' name='{groupname}' vid='{id}' value='{id}' vname={name}>{name}</label></div>{child}</div>";
			resultstr+=template1.format(showitem); 
			});	
	}
	return resultstr; 
}
	
String.prototype.format = function(args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if(args[key]!==undefined){
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] !== undefined) {
　　　　　　　　　　　　var reg2= new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg2, arguments[i]);
                }
            }
        }
    }
    return result;
};