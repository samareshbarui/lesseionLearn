<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${custom_Page_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	
	<meta name="theme-color" content="#272833" />
	
	<#assign 
		layout_og_title = layout.getExpandoBridge().getAttribute("OG Title")
		layout_og_description = layout.getExpandoBridge().getAttribute("OG Description")
		layout_og_image = layout.getExpandoBridge().getAttribute("OG Imageurl")
		portal_url = theme_display.getURLPortal()
		current_complete_URL = portalUtil.getCurrentURL(request)
		layout_og_url = portal_url + current_complete_URL 
	/>
	<#assign 
		og_type = "website"
	/>
	
	<!-- Open Graph data -->
	<meta property="og:locale" content="${theme_display.getLanguageId()}">
	<meta property="og:type" content="${og_type}">
	
	<#if layout_og_title=="">
		<meta property="og:title" content="${custom_Page_title}">
	<#else>
		<meta property="og:title" content="${layout_og_title}">
	</#if>
	
	<#if layout_og_description=="">
		<meta property="og:description" content="${custom_Page_desc}">
	<#else>
		<meta property="og:description" content="${layout_og_description}">
	</#if>
	
	<meta property="og:url" content="${layout_og_url}">
	<meta property="og:site_name" content="">
	<meta property="og:image" content="${layout_og_image}">
	<meta property="og:image:secure_url" content="${layout_og_image}">
	<!-- Open Graph data -->
	
	<!-- Twitter Card data -->
	<meta name="twitter:card" content="summary">
	<meta name="twitter:site" content="${layout_og_url}">
	<meta name="twitter:title" content="${layout_og_title}">
	<meta name="twitter:description" content="${layout_og_description}">

	<meta name="twitter:image" content="${layout_og_image}">
	<!-- Twitter Card data -->
	
	<@liferay_util["include"] page=top_head_include />
	
	<!--<link rel="icon" type="image/png" sizes="32x32" href="${images_folder}/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${images_folder}/favicon-16x16.png"> -->  
	
	<link rel="manifest" 
	href="https://pwcinternaldemo.in/o/sample-theme/manifest.json">
	
	<link rel="apple-touch-icon" href="https://cdn.glitch.com/49d34dc6-8fbd-46bb-8221-b99ffd36f1af%2Ftouchicon-180.png?v=1566411949736">
	
</head>

<body class="${css_class}">
<!-- 
<p class="new2"><p></p></p> -->
<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
		<div id="heading">
			<div aria-level="1" class="site-title" role="heading">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</div>
		</div>

		<#if !is_signed_in>
			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if>

		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>

	<section id="content">
		<h2 class="hide-accessible" role="heading" aria-level="1">${the_title}</h2>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<script>

if ('serviceWorker' in navigator) {
  window.addEventListener('load', function() {
    navigator.serviceWorker.register('/o/sample-theme/sw.js', { scope: '/' }).then(function(registration) {
      console.log('ServiceWorker registration successful with scope: ', registration.scope);
    }, function(err) {
      console.log('ServiceWorker registration failed: ', err);
    });
  });
}
</script>

</body>

</html>