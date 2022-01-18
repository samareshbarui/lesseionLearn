<%@ include file="init.jsp" %>

<div class="taglib-social-bookmarks" id="ykmt_column1_2_socialBookmarks">
	<ul class="list-unstyled inline">
		<!-- <li class="taglib-social-bookmark taglib-social-bookmark-twitter tw">
			<a onclick="basicPopup(this.href);return false" class="btn btn-outline-secondary btn-monospaced btn-outline-borderless btn-sm lfr-portal-tooltip twitter-share-btn"
			id="hjoc" data-title="Twitter" aria-describedby="yui_patched_v3_18_1_1_1620800678307_2811hjoc">
				<svg class="lexicon-icon lexicon-icon-twitter" focusable="false" role="presentation" viewBox="0 0 512 512">
				<path class="lexicon-icon-outline" d="M512.015 97.213c-18.842 8.368-39.089 14.015-60.332 16.531 21.68-12.991 38.358-33.589 46.2-58.108-20.306 12.026-42.776 20.774-66.71 25.485-19.164-20.423-46.462-33.179-76.688-33.179-58.020 0-105.039 47.048-105.039 105.039 0 8.222 0.936 16.238 2.721 23.934-87.308-4.389-164.698-46.2-216.516-109.749-9.041 15.508-14.22 33.559-14.22 52.812 0 36.457 18.55 68.612 46.727 87.425-17.234-0.556-33.414-5.267-47.575-13.137 0 0.439 0 0.877 0 1.317 0 50.91 36.222 93.336 84.266 102.99-8.807 2.399-18.082 3.687-27.679 3.687-6.759 0-13.343-0.673-19.779-1.901 13.371 41.723 52.169 72.123 98.135 72.942-35.959 28.176-81.252 44.971-130.465 44.971-8.486 0-16.853-0.498-25.046-1.464 46.493 29.815 101.704 47.195 161.041 47.195 193.226 0 298.879-160.075 298.879-298.879 0-4.565-0.117-9.070-0.293-13.576 20.481-14.776 38.3-33.267 52.374-54.334v0z"></path>
			</svg>
			</a>
		</li> -->
		<!-- https://twitter.com/intent/tweet?text=British+POLO&tw_p=tweetbutton&url=http://uat.mobileluxurycamp.com/blog/-/blogs/british-polo?_com_liferay_blogs_web_portlet_BlogsPortlet_showFlags=true&original_referer=http://uat.mobileluxurycamp.com/blog/british-polo -->
		
		<!-- <li class="taglib-social-bookmark taglib-social-bookmark-facebook fb">
			<a onclick="basicPopup(this.href);return false"	class="btn btn-outline-secondary btn-monospaced btn-outline-borderless btn-sm lfr-portal-tooltip facebook-share-btn"
			target="_blank"	id="eunk" data-title="Facebook"	aria-describedby="yui_patched_v3_18_1_1_1620800678307_5788eunk">
				<svg class="lexicon-icon lexicon-icon-social-facebook" focusable="false" role="presentation" viewBox="0 0 512 512">
				<path class="lexicon-icon-outline"	d="M483.7,0H28.3C12.6,0,0,12.6,0,28.3v455.5C0,499.4,12.6,512,28.3,512h245.2V313.7h-66.7v-77.3h66.7v-57c0-66.1,40.4-102.1,99.4-102.1c28.3,0,52.5,2.1,59.6,3v69.1h-40.9c-32.1,0-38.3,15.2-38.3,37.6v49.3h76.5l-10,77.3h-66.6V512h130.5c15.6,0,28.3-12.7,28.3-28.3V28.3C512,12.6,499.3,0,483.7,0z"></path>
				</svg>
			</a>
		</li> -->
		<li class="">
			<a onclick="basicPopup(this.href);return false" class="twitter-share-btn">
				<img alt="" src="<%=request.getContextPath()%>/images/icons8-twitter-48.png">
			</a>
		</li>
		<li class="">
			<a onclick="basicPopup(this.href);return false" class="facebook-share-btn">
				<img alt="" src="<%=request.getContextPath()%>/images/icons8-facebook-48.png">
			</a>
		</li>
		<li class="">
			<a onclick="basicPopup(this.href);return false" class="linkedin-share-btn">
				<img alt=""	src="<%=request.getContextPath()%>/images/icons8-linkedin-48.png">
			</a>
		</li>

	</ul>
</div>



<script>
$( document ).ready(function() {
    var newBookMarkUrl = window.location.href;
    var pageTitle = document.title;
    console.log("newBookMarkUrl : "+newBookMarkUrl);
    console.log("pageTitle : "+pageTitle);
    $(".facebook-share-btn").attr("href","http://www.facebook.com/sharer.php?u="+newBookMarkUrl);
    $(".twitter-share-btn").attr("href","https://twitter.com/intent/tweet?text="+pageTitle+"&tw_p=tweetbutton&url="+newBookMarkUrl);
    $(".linkedin-share-btn").attr("href","https://www.linkedin.com/shareArticle?mini=true&url="+newBookMarkUrl+"&title="+pageTitle+"&summary=somedescription&source="+newBookMarkUrl);
});
//Popup window function
function basicPopup(url) {
	popupWindow = window.open(url,'popUpWindow','height=600,width=500,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}
</script>

<style>
.taglib-social-bookmarks .taglib-social-bookmark+.taglib-social-bookmark {
    padding-left: .5rem;
}
.taglib-social-bookmarks {
    display: inline-flex;
}
.taglib-social-bookmarks>ul, .taglib-social-bookmarks>div {
    display: inline-flex;
    margin: 0;
    vertical-align: top;
}
.taglib-social-bookmarks .taglib-social-bookmark {
    display: inline-block;
    vertical-align: top;
}
</style>