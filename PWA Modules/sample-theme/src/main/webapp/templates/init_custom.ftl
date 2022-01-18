<#--
This file allows you to override and define new FreeMarker variables.
-->

<#assign custom_Page_title = "" />

<#if layout.getHTMLTitle(locale)??>
	<#assign custom_Page_title = layout.getHTMLTitle(locale) />
</#if>

<#if layout.getDescription(locale)??>
	<#assign custom_Page_desc = layout.getDescription(locale) />
</#if>

