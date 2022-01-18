<%@page import="com.liferay.jwc.news.article.service.JWCBrandMasterLocalServiceUtil"%>
<%@page import="com.liferay.jwc.news.article.model.JWCBrandMaster"%>
<%@page import="Sign.in.Custom.Slider.DAO.SignInCustomSliderDAO"%>
<%@page import="Sign.in.Custom.Slider.DTO.SignInCustomSliderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.jwc.signin.service.SignInLocalServiceUtil"%>
<%@page import="com.jwc.signin.model.SignIn"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="init.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/news.css">

<% 	Log _log = LogFactoryUtil.getLog(this.getClass().getName());%>
<%
	List<SignIn> signInSlidersList = new ArrayList<>();
	signInSlidersList = SignInLocalServiceUtil.getAllSliderImages();
	_log.info(signInSlidersList.size());
	System.out.println("List : "+signInSlidersList.size());
	
	if(themeDisplay.isSignedIn()) {
%>

<%

	List<SignInCustomSliderDTO> signInCustomSliderDTOs = new ArrayList<SignInCustomSliderDTO>(); 
	SignInCustomSliderDAO customSliderDAO = new SignInCustomSliderDAO();
	signInCustomSliderDTOs = customSliderDAO.getAllSliders();	
	_log.info("vvv... "+signInCustomSliderDTOs.size());
%>
 

<portlet:renderURL var="createSliderURL" >
	<portlet:param name="jspPage" value="/createSlider.jsp"/>
</portlet:renderURL>

<div class="newssection">
	<div class="newsheader">
		<span>Sliders</span>
		<a href="<%=createSliderURL.toString() %>" class="button">+ CREATE</a>
	</div>
</div>



 
<div class="articlebox">
	<liferay-ui:search-container total="<%=signInCustomSliderDTOs.size()%>"
		var="searchContainer" delta="4" deltaConfigurable="true"
		emptyResultsMessage="There Are No Slider To Display, Please add New Slider">

		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(signInCustomSliderDTOs, searchContainer.getStart(), searchContainer.getEnd())%>" />
		<liferay-ui:search-container-row
			className="Sign.in.Custom.Slider.DTO.SignInCustomSliderDTO"
			modelVar="slider">
			<div class="article">
				<div class="lefttext">
					<%
						JWCBrandMaster brandMaster = JWCBrandMasterLocalServiceUtil.getJWCBrandMaster(slider.getBrandId());
					%>
					<h4><b><%=brandMaster.getBrandName()%></b> (<%=slider.getImageCount() %> Images)</h4>
					<h3>
					<% 
						String modifiedDate = "";
						String userName = "";
						modifiedDate = slider.getDate();
						userName = slider.getUserName();
					%>
						Published On <%=modifiedDate %> <span>|</span>
						Published By <%=userName %>
					</h3>
					
				</div>
				<div class="rightbtn">
					<portlet:renderURL var="editURL">
						<portlet:param name="brandId" value="<%=String.valueOf(slider.getBrandId()) %>" />
						<portlet:param name="jspPage" value="/createSlider.jsp" />
					</portlet:renderURL>
					<portlet:renderURL var="previewURL">
						<portlet:param name="brandId" value="<%=String.valueOf(slider.getBrandId()) %>" />
						<portlet:param name="jspPage" value="/preview.jsp" />
					</portlet:renderURL>
					<portlet:actionURL var="deleteSliderURL" name="deleteSlider">
						<portlet:param name="brandId" value="<%=String.valueOf(slider.getBrandId()) %>" />
					</portlet:actionURL>
					<div>
						<a href="<%=editURL.toString()%>">Edit</a>
							<%-- <span>|</span>
						<a href="<%=previewURL.toString()%>">View</a> --%>
							<span>|</span>
						<a href="<%=deleteSliderURL.toString()%>">Delete Slider</a>
					</div>
				</div>
			</div>

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>   

<style>

.newsheader .button {
    float: right;
    background: #0c50a3;
    width: 100px;
    padding: 7px 10px;
    color: #fff;
    border: 1px solid #0c50a3;
}
.newsheader .button a:hover{
	text-decoration: none;
}
.rightbtn button {
    width: 115px;
}
.filterdiv {
	display: none;
    opacity: 0.3;
    pointer-events: none;
}
.check{
	display: none;
}
.modal-header{
	height: 50px;
}
.copyBtn{
	cursor: pointer;
}

</style>

<%
		_log.info("User Signed In.........");
	}else {
		_log.info("User not Signed In.........");
%>
		
		<strong>Please Sign in to Add New Slider !</strong><br/><br/>
		<aui:a cssClass="btn btn-primary" href="/c/portal/login" label="Sign In"></aui:a>
		
<%
	} 
%>

<script type="text/javascript">
	function confirmBoxForBack() {
	  var url = "<%=backURL%>";
	  if (confirm("Are You Sure ? ")) {
		  window.location=url;
	  } else {
	    return false;
	  }
	}
</script>