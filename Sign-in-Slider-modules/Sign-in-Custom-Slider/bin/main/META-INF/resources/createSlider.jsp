<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.jwc.signin.service.SignInLocalServiceUtil"%>
<%@page import="com.jwc.signin.model.SignIn"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.jwc.news.article.service.JWCBrandMasterLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.jwc.news.article.model.JWCBrandMaster"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<%
 	Log _log = LogFactoryUtil.getLog(this.getClass().getName());
	
	/*Brand Master List fetch Data*/
	List<JWCBrandMaster> brandMasters = new ArrayList<>();
	brandMasters = JWCBrandMasterLocalServiceUtil.getAllBrands();
	renderRequest.setAttribute("brandMasters", brandMasters);
	
	String brandId = ParamUtil.getString(request, "brandId");
	System.out.println("brandId : "+brandId);
	if(!brandId.equalsIgnoreCase("")){
		List<SignIn> signInSliders = SignInLocalServiceUtil.fetchAllImagesByBrandId(Long.valueOf(brandId));
		System.out.println("signInSliders : "+signInSliders.size());
		if(signInSliders.size()>0){
			for(SignIn ob : signInSliders){
				System.out.println(".... "+ob.getImageUrl());
				%>
				<script>
				$( document ).ready(function() {
					addMedia('<%=ob.getImageUrl()%>','<%=ob.getSignInImageId()%>');
				});
				</script>
				<%
			}
		}
	}
%>

<liferay-portlet:actionURL name="addSlider" var="addSliderURL">
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="deleteMedia" var="deleteMediaURL">
</liferay-portlet:actionURL>

<%-- <liferay-portlet:actionURL name="duplicateBrandCheck" var="brandValidationURL">
</liferay-portlet:actionURL> --%>

<portlet:renderURL var="backURL"> 
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
</portlet:renderURL>

<a href="#" onclick="confirmBoxForBack()" class="previous btn btn-dark">&laquo; Back</a>

<aui:form enctype="multipart/form-data" action="<%= addSliderURL %>" method="post" name="addSlider" id="addSlider">
	<aui:fieldset-group markupView="lexicon">
	    <aui:fieldset cssClass="customBg" collapsed="<%= false %>" collapsible="<%= true %>" label="Slider for Sign-In Page">
			<div class="row">
				<div class="col-sm-12">
					<div class="row">
						<div class="col-sm-6">
							<aui:select name="brand" id="brand" label="Brand Name" required="true" value="<%=brandId %>">
								<aui:option value="">Select</aui:option>
								<c:forEach var="brand" items="${brandMasters}">
									<aui:option value="${brand.brandId}">${brand.brandName}</aui:option>
								</c:forEach>
							</aui:select>
							<%-- <aui:select name="brandName" id="brandName" label="Brand Name" required="true">
								<aui:option value="">Select</aui:option>
								<aui:option value="jwc">JWC</aui:option>
								<aui:option value="jwcc">JWCC</aui:option>
								<aui:option value="jwg">JWG</aui:option>
								<aui:option value="tcc">TCC</aui:option>
							</aui:select> --%>
							<div class="brandErrorMsg"></div>
						</div>
						<div class="col-sm-6">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<input class="mediaCount" name="<portlet:namespace/>mediaCount" id="mediaCount" value="" type="hidden">
							<div class="commonMediaDiv" id="commonMediaDiv"></div>
							<button type="button" class="addMediaBtn btn btn-primary" onclick="addMedia('','')">Add Image</button>
							<div class="sliderErrorMsg"></div>
						</div>
					</div>
				</div>
			</div>
		</aui:fieldset>
	</aui:fieldset-group>
	
	<aui:button-row>
		<aui:button type="button" cssClass="" id="publishBtn" value="Publish"></aui:button>
		<aui:button type="button" id="cancelBtn" onClick="confirmBoxForBack();" value="Cancel"></aui:button>
	</aui:button-row>
</aui:form>	

<%
	if(!brandId.equalsIgnoreCase("")){
%>
<script type="text/javascript">
	$(function(){
		$("#<portlet:namespace/>brand").addClass("disabled");
	});
</script>
<%
	}
%>
<script type="text/javascript">

/* Add dynamically input field while clicking on add images button Start */

var mediaCount = 0;
function addMedia(mediaPath,mediaTemplateId){
	console.log("mediaPath : "+mediaPath);
	mediaCount = $('#commonMediaDiv .mediaDiv[data-type="media"]').length;
	var oldMediaLength = $(".commonMediaDiv").length;
	var newMediaLength = parseInt(oldMediaLength+1);
	mediaCount = parseInt(mediaCount+1);
	console.log("mediaCount : "+mediaCount);
	var mediaNumber = '<label class="mediaNumber text-white bg-dark">Image '+mediaCount+'</label>';
	var deleteMedia = '<label class="deleteMedia text-white bg-dark">Delete</label><br/>';
	
	var inputHiddenForUpdate = '<input class="mediaTemplateId" name="<portlet:namespace/>mediaTemplateId-'+mediaCount+'" id="mediaTemplateId" value="'+mediaTemplateId+'" type="hidden">';
	
	var sliderInputHidden = '<input class="sameMediaUrl" name="<portlet:namespace/>sameMediaUrl-'+mediaCount+'" id="sameMediaUrl" value="'+mediaPath+'" type="hidden">';
	var html = '<div class="row customRow"><div class="col-sm-6"><label class="mediaLabel" for="<portlet:namespace/>media-'+mediaCount+'">Select a Image file <span class="red">*</span>: </label><br/>'+' <input name="<portlet:namespace/>media-'+mediaCount+'" class="mediaInput" id="media-'+mediaCount+'" type="file" ></div>';  /* onchange="readSliderImageURL'+mediaCount+'(this);" */
	var previewImgHtml = '<div class="col-sm-6"><img width="40%" class="sliderImageView hide" id="sliderImageView-'+mediaCount+'" src="'+mediaPath+'" alt="sliderImageView" style="float: left;" ></div></div>';
	$("#mediaCount").val(mediaCount);
	var fullMediaHtml = "<div class='mediaDiv' data-type='media' id='mediaDiv-"+mediaCount+"'>"+mediaNumber+deleteMedia+inputHiddenForUpdate+sliderInputHidden+html+previewImgHtml+"</div>";
	
	$("#commonMediaDiv").append(fullMediaHtml);
	
	if(mediaPath!=""){
		$("#sliderImageView-"+mediaCount).removeClass("hide");
	}
	
}

/* Add dynamically input field while clicking on add images button End */


/* Delete media on click Start */
$(function(){
	$(document).on("click",".commonMediaDiv .deleteMedia", function () {
		console.log("call");
		var dataType = $(this).parent().attr("data-type");
		
		//media database delete
		var url = "<%=deleteMediaURL.toString()%>"; 
		var mediaId = $(this).siblings(".mediaTemplateId").val();
		console.log("mediaId : "+mediaId);
		if(mediaId!=""){
			$.ajax({
				url: url,
				data: {
					'<portlet:namespace/>mediaId':mediaId ,
					'<portlet:namespace/>dataType':dataType
					},
				success: function(result){
					console.log("success...");
				},
				error: function(){
					alert("error");
				}
			});
		}
		//media database delete
		
		var commonMediaDivId = $(this).parent().parent().attr("id");
		//alert("commonMediaDivId : "+commonMediaDivId);
		//alert("iuytyuytrtyuy : "+$(this).parent().attr("id"));
		
		var arr = commonMediaDivId.split("-");
		var sliderNum = arr[1];
		$(this).parent().remove();
		//$(this).parent().css("background","red");
		var mediaCountInput = $("#mediaCount").val();
		mediaCountInput = parseInt(mediaCountInput-1);
		$("#mediaCount").val(mediaCountInput);
		if(dataType=="media"){
			var mediaCount = 0;
			$('#commonMediaDiv' + ' .mediaDiv[data-type="media"]').each(function(){
				console.log("Inside loop : --media count : "+(mediaCount+1));
				$(this).attr("id","mediaDiv-"+(mediaCount+1));
				$(this).find(".mediaTemplateId").attr("name","<portlet:namespace/>mediaTemplateId-"+(mediaCount+1));
				$(this).find(".sameMediaUrl").attr("name","<portlet:namespace/>sameMediaUrl-"+(mediaCount+1));
				$(this).find(".mediaLabel").attr("for","<portlet:namespace/>media-"+(mediaCount+1));
				$(this).find(".mediaInput").attr("id","media-"+(mediaCount+1));
				$(this).find(".mediaInput").attr("name","<portlet:namespace/>media-"+(mediaCount+1));
				$(this).find(".mediaNumber").text("Image "+(mediaCount+1));
				mediaCount++;
			});
		}
			
	});
	
});

/* Delete media on click End*/


$("#<portlet:namespace/>brand").change(function(){
	var brandId = $(this).val();
	console.log("brandId : "+brandId);
	var url = "/api/jsonws/jwc.signin/get-slider-by-brand/brand-id/"+brandId; 
	$.ajax({
        url: url,
        data: {
        	'<portlet:namespace/>brandId':brandId 
        	},
        success: function(data){
            console.log("success: "+data);
            if(data=="exist"){
            	$(".brandErrorMsg").text("Sliders for this Brand is already exist.");
            	$("#<portlet:namespace/>publishBtn").addClass("disabled");
            	$("#<portlet:namespace/>cancelBtn").addClass("disabled");
            }else{
            	$(".brandErrorMsg").text("");
            	$("#<portlet:namespace/>publishBtn").removeClass("disabled");
            	$("#<portlet:namespace/>cancelBtn").removeClass("disabled");
            }
        },
        error: function(){
        	alert("error");
        }
	});
});


/* Form Submission with validation Start */
	
	$("#<portlet:namespace/>publishBtn").click(function(){
		console.log("Calling.....");
		var validationCheck = false;
		var btnVal = $(this).find(".lfr-btn-label").text();
		console.log(btnVal);
		$("#<portlet:namespace/>btnVal").val(btnVal);
		
		if($("#<portlet:namespace/>brand").val()==""){
			$("#<portlet:namespace/>brand").parent().siblings(".brandErrorMsg").text("Brand Name Cannot be blank");
			$("#<portlet:namespace/>brand").focus();
			validationCheck = true;
		}else{
			$("#<portlet:namespace/>brand").parent().siblings(".brandErrorMsg").text("");
		} 
		
		//news article details template validation check for rquired
		if(validateNewsArticleDetails()){
			return false;
		}
		
		if(validationCheck){
			return false;
		}
		
		//alert("go to submit");
		$("#<portlet:namespace/>addSlider").submit();
	});
		
/* Form Submission with validation End */		


/* Validation for form Start */

	function validateNewsArticleDetails(){
		console.log("inside validateNewsArticleDetails");
		$(".sliderErrorMsg").text("");
		var mediaCount = $("#mediaCount").val();
		console.log("mediaCount: "+mediaCount);
		if(mediaCount>0){
			for(var j=1; j <= mediaCount; j++){
				var inputMediaVal = $("#media-"+j).val();
				if(inputMediaVal==""){
					if($('input[name="<portlet:namespace/>sameMediaUrl-'+j+'"]').val()==""){
						$(".sliderErrorMsg").text("Please add images in the input field");
						mediaValidationCheck = true;
						break;
					}else{
						$(".sliderErrorMsg").text("");
						mediaValidationCheck = false;
					}
				}else{
					$(".sliderErrorMsg").text("");
					mediaValidationCheck = false;
				}
			}
			
		}else{
			$(".sliderErrorMsg").text("Please add atleast one image for slider");
			mediaValidationCheck = true;
		}
		
		if(mediaValidationCheck){
			return true;
		}else{
			return false;
		}
	}

/* Validation for form End */


/* Display preview images while uploading start */	
		
	$(document).on('change', '.mediaInput', function() {
		  // Does some stuff and logs the event to the console
		  //alert("...change method call...");
		  //const file = this.files[0];
		  var imgTag = $(this).closest(".customRow").find("img.sliderImageView");
		  var input = this;
		  if (input.files && input.files[0]) {
		        var reader = new FileReader();
		        reader.onload = function (e) {
		        	//$(".sliderImageView").attr('src', e.target.result);
		        	console.log("e.target.result: " +e.target.result);
		        	imgTag.attr('src', e.target.result);
		        };

		        reader.readAsDataURL(input.files[0]);
		        imgTag.removeClass("hide");
		    }
	}); 
	
/* Display preview images while uploading End */		
		
	function confirmBoxForBack() {
	  var url = "<%=backURL%>";
	  if (confirm("Are You Sure ? ")) {
		  window.location=url;
	  } else {
	    return false;
	  }
	}	
	
</script>

<style>
.publishBtn{
	background-color: #0c50a3;
    color: #fff;
}

.customAreaDiv{
	border: 2px solid #9d8a8a;
    padding: 10px;
}
.table-container table{
    border: 1px solid #222;
}

.table-container table th,
.table-container table td{
    border: 1px solid #222;
}


#noSectionTable{
    border: 2px solid #222;
    padding: 20px 0px 20px 0px;
    text-align: center;
}
.disabled{
    pointer-events: none;
    color: #a2b0e5;
}
.brandErrorMsg,.sliderErrorMsg{
	
    color: red;
    font-weight: 500;
    font-family: monospace;
    margin-top: 15px;
}
#sectionTable tbody td input{
	width: 100%;
}
.required {
    display: none;
}
a {
  text-decoration: none;
  display: inline-block;
  padding: 8px 16px;
}

a:hover {
  background-color: #ddd;
  color: black;
}

.previous {
  text-decoration: none !important;
  margin-bottom: 10px;
}

.videoInlineTextLabel, .cImageInlineTextLabel,.sliderInlineTextLabel,.fullWidthMediaInlineTextLabel{
	padding-right: 6px;
    position: relative;
    bottom: 40px;
}
.mediaDiv {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 3px solid #e5e5e5;
    padding: 10px 0px 10px 10px;
    width: 97%;
}
label[for] {
    padding-right: 10px;
}
.sliderAlignmentLabel{
	padding-right: 10px;
	margin-top: 10px;
}
.mediaTypeLabel{
	padding-right: 10px;
}
select.mediaType, select.sliderAlignment, select.fullWidthMediaType{
	width: 170px;
    height: 35px;
    margin-bottom: 15px;
}
.commonMediaDiv{
    border: 1px solid #c8bbbb;
    padding: 0px 0px 0px 25px;
    margin-top: 20px;
    margin-bottom: 20px;
}
.mediaNumber{
	padding: 2px 5px 2px 5px;
}
.customBg .panel-heading{
	background-color: #0c50a3;
	color: #fff;
} 
.customBg .panel-heading:hover{
	background-color: #5a96df;
	color: #fff;
} 
.customBg .panel-heading a:hover{
	background-color: #5a96df;
	color: #fff;
	text-decoration: none;
} 
.color-red{
	color: red;
}
.red{
	color: red;
    font-size: 20px;
}
.type{
    padding-left: 10px;
    text-transform: capitalize;
}
.deleteMedia{
	float: right;
    padding: 6px 15px 6px 15px;
    margin-right: 10px;
    cursor: pointer;
    font-size: 15px;
}

.removeBtn{
    border: 1px solid #0c50a3;
    padding: 2px 5px 5px 5px;
    cursor: pointer;
    border-radius: 0.25rem;
    margin-left: 30px;
}


</style>