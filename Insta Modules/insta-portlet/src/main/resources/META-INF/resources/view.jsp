<%@page import="jwc.insta.service.InstaOtherDetailsLocalServiceUtil"%>
<%@page import="jwc.insta.model.InstaOtherDetails"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="jwc.insta.service.HandleAPIKeysLocalServiceUtil"%>
<%@page import="jwc.insta.model.HandleAPIKeys"%>
<%@page import="insta.portlet.constants.InstaPortletKeys"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="init.jsp" %>
 
<style>
.checkboxes {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  vertical-align: middle;
  word-wrap: break-word;
}

.checkdisabled{
  pointer-events:none;
 
}

.disabledDiv {
    pointer-events: none;
    opacity: 0.4;
}
.form-select {
	margin-right: 15px;
    width: 30%;
    padding: .375rem 2.25rem .375rem .75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    background-color: #fff;
    background-repeat: no-repeat;
    background-position: right .75rem center;
    background-size: 16px 12px;
    border: 1px solid #ced4da;
    border-radius: .25rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}

.class-no-data{
    font-weight: bold;
    font-family: cursive;
    font-size: 20px;
    color: red;
}

</style> 
 
     
<body>

<%
	String pageKey = "";
	String pageKeyVal = (String)renderRequest.getAttribute("selectVal");
	System.out.println("Selected Value.. : "+ renderRequest.getAttribute("selectVal")+".."+pageKeyVal);
	if(renderRequest.getAttribute("selectVal")!=null){
		System.out.println("inside not null...");
%>
	<script type="text/javascript">
	$(function(){
		console.log("not blank");
		var keyValue = "<%=pageKeyVal%>";
		console.log("keyValue : "+keyValue);
		$("#selectKeyOfPage").val(keyValue);
		$("#instagram-feed2").show();
		$(".ct-btn").removeClass('hide');
	});
	</script>
	
<%	} %>

<portlet:actionURL name="getPageKey" var="getPageKeyURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:actionURL>

<aui:form action="<%=getPageKeyURL %>" method="post">
	
	<select class="form-select" name="<portlet:namespace/>abc" id="selectKeyOfPage" >
		<option value=""><--Select--></option>
		<option value="CEC">CEC</option>
		<option value="DAS">DAS</option>
	</select>
	
	<aui:button type="submit" value="Get Posts"></aui:button>
</aui:form>


<%

//TODO : replace the static page key with select dropdownlist selected deafult value
System.out.println("Selected Value..again.."+pageKeyVal);
pageKey = pageKeyVal;
String APIKey = "";

if(!HandleAPIKeysLocalServiceUtil.getHandleAPIByPageKey(pageKey).isEmpty()){
	APIKey = HandleAPIKeysLocalServiceUtil.getHandleAPIByPageKey(pageKey);
	System.out.println("inside if :: "+APIKey);
}else{
	APIKey = InstaPortletKeys.INSTA_API_KEY_DEFAULT;
	System.out.println("inside else :: "+APIKey);
}


HandleAPIKeys handleAPIKeys = HandleAPIKeysLocalServiceUtil.getHandleAPIRowByPageKey(pageKey);

boolean hideInstagramWidget = false;

if(handleAPIKeys != null){
	hideInstagramWidget = handleAPIKeys.getInstagramWidgetFlag();
	//System.out.println("The api flag :" + hideInstagramWidget);
}


request.setAttribute("APIKey", APIKey);
 
//List<InstaSiteImages> instaImagesList = InstaSiteImagesLocalServiceUtil.getInstaSiteImageses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
List<InstaSiteImages> instaImagesList = InstaSiteImagesLocalServiceUtil.getPostsByPageKey(pageKey);

List<String> permLinkIds = new ArrayList<String>();

  String instaUrls = "";
  String mediaUrls = "";
  String timestamps = "";
  String json = "";
  
  long instaOtherDetId = 0;
  String instaHandleName = "";
  String followUsLink = "";
  
  List<String> instaUrlArray = new ArrayList<String>();
  List<String> mediaUrlArray = new ArrayList<String>();
  List<String> timestampArray = new ArrayList<String>();

  
  Map<String, String> imagesDetailsMap = new HashMap<String, String>();
  
  //Map<String, Map> instaSeletedImagesMap = new HashMap<String, Map>();
  

if(instaImagesList != null) {
		
   for(InstaSiteImages instaSiteImage : instaImagesList) {
	   
	   System.out.println("size :" + instaImagesList.size());
		// permLinkIds.add(instaSiteImage.getInstaimageUrl());
		//instaUrls = instaSiteImage.getInstaimageUrl();
		
		instaUrlArray.add(instaSiteImage.getInstaimageUrl());
		mediaUrlArray.add(instaSiteImage.getMediaUrl());
		timestampArray.add(instaSiteImage.getTimestamp());
		
		imagesDetailsMap.put(instaSiteImage.getInstaimageUrl(), instaSiteImage.getMediaUrl()+"-TIMESTAMP-"+ instaSiteImage.getTimestamp());
		//imagesDetailsMap.put("medialink" , instaSiteImage.getMediaUrl());
		//imagesDetailsMap.put("timestamp" , instaSiteImage.getTimestamp());
		  
		//instaSeletedImagesMap.put("instaImgRetained", imagesDetailsMap);
		instaOtherDetId=instaSiteImage.getOtherDetid();
					
	}
    
   
   instaUrls = String.join(",", instaUrlArray);
   mediaUrls = String.join(",",mediaUrlArray);
   timestamps = String.join(",", timestampArray);
   
   json = new ObjectMapper().writeValueAsString(imagesDetailsMap);
   System.out.println(json);
   
   request.setAttribute("json", json);
	
}

//System.out.println("instaurls from db :" + instaUrls);
//System.out.println("media urls from db :" + mediaUrls);
//System.out.println("timestamp from db :" + timestamps);

//request.setAttribute("permlinks", instaUrls);

if(instaOtherDetId != 0){
	InstaOtherDetails details = InstaOtherDetailsLocalServiceUtil.getInstaOtherDetails(instaOtherDetId);
	instaHandleName = details.getInstaHandleName();
	followUsLink = details.getFollowUsLink();
}

%>







<div id="jquery-script-menu">
<div class="jquery-script-center">
<ul>

</ul><div id="carbon-block"></div>
</div>
<div class="jquery-script-clear"></div>
</div>

<input type="hidden" name="allEditCheckedInstaIds" id="allEditCheckedInstaIds" value="<%=instaUrls%>"/>
<input type="hidden" name="allEditCheckedMediaIds" id="allEditCheckedMediaIds" value="<%=mediaUrls%>"/>
<input type="hidden" name="allEditCheckedTimestamp" id="allEditCheckedTimestamp" value="<%=timestamps%>"/>
<input type="hidden" name="APPKY" id="APPKY" value="<%=APIKey%>"/>


<script type="text/javascript">

    var myVar = <%= request.getAttribute("json") %>; 
    
    var apiKey = '<%=request.getAttribute("APIKey") %>'; 
	
	
	//document.write("ttttttttttttt:========" + obj1);
	
	//document.write("loop");
	
	
		
  
</script>






<label for="checkall" class="checkboxes">
<input type="checkbox" id="checkall" name="checkall"  class="checkboxes"/>
&nbsp;CHECK/UNCHECK ALL
</label>



  

  <div class="container">
  
  <liferay-portlet:actionURL name="addInstaImageOnSite" var="instaImageFormUrl">
  	
  </liferay-portlet:actionURL>
  
  
  
  
  
  <aui:form action="<%= instaImageFormUrl %>" method="post" name="instaimageform" id="instaimageform">  
  <%--TODO when other pages requirement will come
   <aui:select name="pageName">
   <aui:option></aui:option>
    
  </aui:select> --%>
  
   <input type="hidden" name="<portlet:namespace/>hiddenKeyOfPage" id="hiddenKeyOfPage" value="<%=pageKeyVal%> ">
  
   <%
    if(!hideInstagramWidget){
   %>
   <aui:input type="checkbox" name="hideInstagramWidget" id="hideInstagramWidget" onChange ="valueChanged()" class="hideInstaCheck" label="HIDE INSTAGRAM WIDGET ON SITE"/>
   <%
    } else{
	   
   %>
	   <aui:input type="checkbox" name="hideInstagramWidget" id="hideInstagramWidget" onChange ="valueChanged()" class="hideInstaCheck" label="HIDE INSTAGRAM WIDGET ON SITE" checked="true"/>   
   <% 
   }
   %> 
   
  <div  id="instagramDiv">  
  <div id="instagram-feed1" class="instagram_feed">
  </div>
  
  <br>
  <br>
  
  
  <div id="instagram-feed2" class="instagram_feed" style="display:none"> </div>
  </div>     
 
    
   <aui:input type="hidden" name="allCheckedMediaIds"  id="allCheckedMediaIds" value=""/>
   <aui:input type="hidden" name="allCheckedInstaIds" id="allCheckedInstaIds" value=""/>
   <aui:input type="hidden" name="allCheckedTimeStamp" id="allCheckedTimeStamp" value=""/>
  
   <div class="row">
   	<div class="col-sm-6"><aui:input name="handleName" id="handleName" required="true" label="Handle Name" value="<%=instaHandleName %>"></aui:input></div>
   	<div class="col-sm-6"><aui:input name="followUsLink" id="followUsLink" required="true" label="Follow Us Link" value="<%=followUsLink %>"></aui:input></div>
   </div>
  
        
  
  <div class="d-flex justify-content-center">
  
    <aui:button-row>
		<aui:button cssClass="ct-btn hide" type="submit" id="submit" value="Submit"></aui:button>
	</aui:button-row>
  </div>
  
  
  
            
  
  
  </aui:form>

</div>

<script src="<%=request.getContextPath()%>/js/jquery-feed-instagram-graph.js?v5"></script>    


<script>

$(document).ready(function() {
	  $('#checkall').click(function() {
	    var checked = $(this).prop('checked');
	    $('#instagramDiv').find('input:checkbox').prop('checked', checked);
	  });
	  
});


$(function() {
	disableEnable_cb();
    $("#<portlet:namespace/>hideInstagramWidget").click(disableEnable_cb);
});

function disableEnable_cb() {
	  if ($("#<portlet:namespace/>hideInstagramWidget").is(':checked')) {
		  $(".insta-check").attr("disabled", true);	   
		  $("#checkall").attr("disabled", true);
		  $('#instagramDiv').addClass("disabledDiv");
		  } else {
		  $(".insta-check").removeAttr("disabled");
		  $("#checkall").removeAttr("disabled");
		  $('#instagramDiv').removeClass("disabledDiv");
		 
	  }
	} 


	
$("#<portlet:namespace/>submit").on('click', function() {
	 var favorite = [];
	 var val = [];
	 var checkboxArray = "";
	 var mediaUrl = [];
	 var permlink = [];
	 var timestamp = [];
	 var mediaUrlInputField = "";
	 var permlinkInputField = "";
	 var timestampInputField = "";
	 var checkedEles = $(".insta-check input:checkbox:checked");
	 
	 
	/*  if($('input:checkbox:checked').length == 0){
		 alert("Please select atleast one image"); 
		 return false;
	 } */
	 
	 $('.insta-check:checkbox:checked').each(function(i){
		 val[i] = $(this).val();
		 checkboxArray = ($(this).val()).split("-INSTAMEDIA-");
		 mediaUrl[i] = checkboxArray[0];
		 permlink[i] = checkboxArray[1];
		 timestamp[i] = checkboxArray[2];
		 
		 
		// $('#<portlet:namespace/>allCheckedMediaIds').val(mediaUrl);
		 //$('#<portlet:namespace/>allCheckedInstaIds').val(permlink);		 
		 
     });
	 
	 mediaUrlInputField = mediaUrl.join(",");
	 permlinkInputField = permlink.join(",");
	 timestampInputField = timestamp.join(",");
	 
	 
	// alert("permlink id : " + mediaUrlInputField);	  
	 //alert("permlink id : " + permlinkInputField);
	 //alert("permlink id : " + timestampInputField);	 
	 
	 
	 $('#<portlet:namespace/>allCheckedMediaIds').val(mediaUrlInputField);
	 $('#<portlet:namespace/>allCheckedInstaIds').val(permlinkInputField);
	 $('#<portlet:namespace/>allCheckedTimeStamp').val(timestampInputField);
	 
	 
     //alert("Media Url : " + $('#<portlet:namespace/>allCheckedMediaIds').val());
     //alert("Insta Url : " + $('#<portlet:namespace/>allCheckedInstaIds').val());
     //alert("Timestamp Url : " + $('#<portlet:namespace/>allCheckedTimeStamp').val());
     
     
	 window.confirm("Submitting this data will delete your past selection and update your current selection");
     
     
   });


   

   </script>

</body>