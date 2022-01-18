/* jQuery Ajax for feed Instagram Graph API*/
if ( $('#instagram-feed1').length != 0 ) {

    /*var token = 'IGQVJXZAW5iRENWTkk5N2R4ZA1Q1U1BXUk01djhZARmw4UXBtSnRIaFI4ZA2tnZAUxLLTdsa0NvZA2kzVkNHbmh6cFU3OGExMnpNV1NXZAWNFNmxuNVpocTZAwczRDTWV5WUItcU55N1NYZAkVFRG1oZAEJLLUNNMwZDZD';*/
    /*var token = 'IGQVJVQV9OSFhZATUluQVZA4SUNRVkFyVXc5LXNXUmc0MnowTnUyRmRnNDhXalFHRWRZAcy03a24zeHZAtaUM3WmdSMkVSTWEzMlAyUGZAlR3pOcUwwWjdLYVp5WUpCRmNaYXlyb29LcUpTb1NGdlVPbExNZAQZDZD';*/
    /*var token ='IGQVJYXzBaTjdrYzBLaUJLcXdiVDEzM0JDQl9XSDhFMlJJUXE0YjJZAYmZA3ZAWpZASmQ2bnE4dDRCZAkM5WHNoV1d3c3AyVDFmZAk1LZA0FpRHJxa0sxc3k2QWxmSEFrWlVSRGszX01MTXcyNkY0VVJYV1FKTwZDZD';*/
    
	//sb20210917 //Welcome@1234
//	var token = 'IGQVJWamlJdE9MQWJZATFMtNmdUMFVQazFyS25sRnVIcHpnYVNtcTQ2eXVxakg3bTNPVVpTUUVESmhWaUtJYkdTR2FqVU1kc3hZAbHEwOFpDNE8waHVwQ0toT3QxMmFXSFZACanlTTUNuVDBoX1dOVXcwYwZDZD';
    
	var token = $('#APPKY').val();
	var fields = 'id,media_type,media_url,thumbnail_url,timestamp,permalink,caption';
    var limit = 3; // Set a number of display items
	var debug = true;
	var alreadyOnSite = false;
	var editIds = "";

	/*alert("inside js :" + editIds);*/
	
	var element =  $('#allEditCheckedInstaIds').val();
	
	if(element != null && element != undefined && element != ""){
		editIds = element ;
	}
	
	var jsonstring = JSON.stringify(myVar);
	var jsonobject = JSON.parse(jsonstring);
	console.log("jsonstring : "+jsonstring+" ..jsonobject.."+jsonobject);
	/*alert("String :" + jsonstring);*/
	
	var ajaxFunctionExecuted = "false";
	/*var modifiedJsonObject = "";*/
	
	/*alert(jsonstring);*/
	
	
    $.ajax ({
        url: 'https://graph.instagram.com/me/media?fields='+ fields +'&access_token='+ token +'&count=-1',	
        type: 'GET',
        success: function( response ) {
            for( var x in response.data ) {
                var link = response.data[x]['permalink'],
                    caption = response.data[x]['caption'],
                    image = response.data[x]['media_url'],
                    image_video = response.data[x]['thumbnail_url'],
                    timestamp = response.data[x]['timestamp']
                    html = '';
                
               
                	if(editIds.indexOf(link) != -1){

                  	  alreadyOnSite = true ;
                    }else{

                  	  alreadyOnSite = false ;
                    }
               
                  
                	for (var key in jsonobject) {
            		    if (jsonobject.hasOwnProperty(key)) {            		    	
            		    	if(key == link){            		    		
            		    		console.log ("matched :" + key);
            		    		delete jsonobject[key]; 
            		        }        		    	
            		    }
            		    
            		} 
                  
                var checkboxvalueimage = image + "-INSTAMEDIA-" + link + "-INSTAMEDIA-" + timestamp;  
                var checkboxvaluevideo = image_video + "-INSTAMEDIA-" + link  + "-INSTAMEDIA-" + timestamp;  
                
                if ( response.data[x]['media_type'] == 'VIDEO' ) {
                    html += '<div class="instagram_new border">';
                      html += '<a class="insta-link" href="' + link + '" rel="noopener" target="_blank">';
                        html += '<img src="' + image_video + '" loading="lazy" alt="' + caption + '" class="insta-image" />';
                     html += '</a>';
                     
                     if(alreadyOnSite == false){
                     
						html += '<input type="checkbox" class="insta-check"  id="' + link + '" name="' + link + '" value="' + checkboxvaluevideo + '">';
						html += '<label for="' + link + '" class="btn btn-warning">Show on Site</label>';
                     }else if (alreadyOnSite == true){	
						
						html += '<input type="checkbox" class="insta-check" id="' + link + '" name="' + link + '" value="' + checkboxvaluevideo + '" checked>';
						html += '<label for="' + link + '" class="btn btn-warning">Available on Site</label>';
						
                     }	
						
                    html += '</div>';
                } else {
                    html += '<div class="instagram_new">';
                        html += '<a class="insta-link" href="' + link + '" rel="noopener" target="_blank">';
                            html += '<img src="' + image + '" loading="lazy" alt="' + caption + '" class="insta-image" />';
                        html += '</a>' ;
                        
                        
                        if(alreadyOnSite == false){
						html += '<input type="checkbox" class="insta-check" id="' + link + '" name="' + link + '" value="' + checkboxvalueimage + '">';
						html += '<label for="' + link + '" class="btn btn-warning">Show on Site</label>';
						
                        }else if ((alreadyOnSite == true)){
                        	html += '<input type="checkbox" class="insta-check" id="' + link + '" name="' + link + '" value="' + checkboxvalueimage + '" checked>';
    						html += '<label for="' + link + '" class="btn btn-warning">Available on Site</label>';
    						
                        }
												
                    html += '</div>';
                } 
                $('#instagram-feed1').append(html);
            }
            
            ajaxFunctionExecuted = "true"; 
                      
         },   
        
        
        error: function(data) {
            var html = '<div class="class-no-data">No Latest Posts Found From the Handle</div>';
            $('#instagram-feed1').append(html);
            $(".justify-content-center button.ct-btn").addClass("hide");
        },
            
        complete: function (data) {
            	console.log("jsonobject : "+jsonobject);
            	console.log("size of json object  while last:" + Object.keys(jsonobject).length)
                if((Object.keys(jsonobject).length) > 0){
                /* var html = ''; */	
                
                console.log("Inside the loop :" );
                	
                for (var key in jsonobject) {
            	    if (jsonobject.hasOwnProperty(key)) {
            	    	
            	    	 var html = '';	
            	    	 var jsonvalue = jsonobject[key];
            	    	 var instaMediaArray = jsonvalue.split("-TIMESTAMP-");
            	    	 var instaLink = key;
            			 var mediaLink = instaMediaArray[0];
            			 var timestamp = instaMediaArray[1]
            			 var inputfieldValue = mediaLink + "-INSTAMEDIA-" + instaLink + "-INSTAMEDIA-" + timestamp;
            			 
            	    	 // String mediaLink ="";
            			 html += '<div class="instagram_new">';
                         html += '<a class="insta-link" href="' + instaLink + '" rel="noopener" target="_blank">';
                             html += '<img src="' + mediaLink + '" loading="lazy"  class="insta-image" />';
                         html += '</a>' ;
                         
                         html += '<input type="checkbox" id="' + instaLink + '" name="' + instaLink + '" value="' + inputfieldValue + '" checked>';
            			 html += '<label for="' + mediaLink + '" class="btn btn-warning">Available on Site</label>';
                         
                         html += '</div>';            
            			        		    	
            	    }
            	    
            	    $('#instagram-feed2').append(html);
            	    $('#instagram-feed2').css("display","block");
            	    
                 } 
                alert("Token has been expired..!!");
           }    
            	
        }
            
       
    });
    
}



