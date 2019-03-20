$(function(){
	   $('#tt').tree({      
	        url: 'getMenu.do',      
	        loadFilter: function(data){    
	        	//console.info(data.menu);
	                return data.menu;      
	            },
            onClick: function(node){
    			//alert(node.text);  // alert node text property when clicked
    			//console.info(node.attribute["url"]);
    			var text=node.text;
    			var url="main.jsp"//node.attribute["url"];
    			    //区分是否有叶子节点，是则添加tab
    				if($('#tt').tree('isLeaf',node.target)){ 
    					addTab(text,url);
    				}    			
    		}
	   });  
	   function addTab(title,url){
		   	if ($('#t').tabs('exists', title)){
		   		$('#t').tabs('select', title);
		   	} else {
		   		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		   		$('#t').tabs('add',{
		   			title:title,
		   			content:content,
		   			closable:true
		   		});
		   	}
		   };
   });