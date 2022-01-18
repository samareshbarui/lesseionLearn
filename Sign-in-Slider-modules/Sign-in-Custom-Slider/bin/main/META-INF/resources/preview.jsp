<%@page import="com.jwc.signin.service.SignInLocalServiceUtil"%>
<%@page import="com.jwc.signin.model.SignIn"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="init.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main-liferay.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/merge.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/custom.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/google-api.js"></script>
<script src="<%=request.getContextPath() %>/js/three.js"></script>
<script type="module" src="<%=request.getContextPath() %>/js/360.js"></script>

<portlet:renderURL var="backURL"> 
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
</portlet:renderURL>

<a href="#" onclick="confirmBoxForBack()" class="previous btn btn-dark">&laquo; Back</a>

<%
 	Log _log = LogFactoryUtil.getLog(this.getClass().getName());
	String brandId = ParamUtil.getString(request, "brandId");
	System.out.println("brandId : "+brandId);
	
  	List<SignIn> signInSliders = SignInLocalServiceUtil.fetchAllImagesByBrandId(Long.valueOf(brandId));
	System.out.println("signInSliders : "+signInSliders.size());
	if(signInSliders.size()>0){
		%>
		<div class="jwc-lportal">
			<div class="slider col-md-8">
				<div class="bg_before_left" style="-data-bglayer-color: #C69E67">
					<div class="benefits_slider jwc_swiper_benefits" data-interval="4">
						<div class="swiper-container">
							<div class="swiper-wrapper">
		<%
		int i = 1;
		for(SignIn ob : signInSliders){
	  		System.out.println(".... "+ob.getUserName());
	  		
	  	%>	
				  				<div class="swiper-slide">
									<div class="benefits_slider_each">
										<img src="<%=ob.getImageUrl() %>" class="img-fluid" alt="slider <%=i%>">
									</div>
								</div>
	  	<%	
	  	i++;
  		}
	}
%>
				
						</div>
					</div>
					<!-- Add Pagination -->
					<div class="swiper-pagination"></div>
				</div>
			</div>
			<p></p>
		</div>
	</div>

<script>	
	function confirmBoxForBack() {
	  var url = "<%=backURL%>";
	  if (confirm("Do you want to Back ? ")) {
		  window.location=url;
	  } else {
	    return false;
	  }
	}	
	
</script>

<style>
.jwc-lportal{
	margin-top: 40px;
}
</style>