package Sign.In.Slider.Api.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import Sign.In.Slider.Api.Dao.SignInBrandDAO;
import Sign.In.Slider.Api.Dto.ImageUrls;
import Sign.In.Slider.Api.Dto.SignInBrandDTO;
import Sign.In.Slider.Api.Dto.SlidersDto;

/**
 * @author sbarui002
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/brandsliders",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=BrandSliders.Rest"
	},
	service = Application.class
)
public class SignInSliderApiApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}
	
	@GET
	@Path("/getAllBrandSliderImages")
	@Produces("application/json")
	public List<SlidersDto> getAllBrandSliderImages() throws SQLException {
		
		SlidersDto slidersDto = null;
		List<SlidersDto> listOfSliders = new ArrayList<SlidersDto>();
		
		List<SignInBrandDTO> signInCustomSliderDTOs = new ArrayList<SignInBrandDTO>(); 
		SignInBrandDAO customSliderDAO = new SignInBrandDAO();
		signInCustomSliderDTOs = customSliderDAO.getAllBrandSliders();	
		System.out.println("Brand size... "+signInCustomSliderDTOs.size());
		
		for(SignInBrandDTO ob : signInCustomSliderDTOs) {
			slidersDto = new SlidersDto();
			slidersDto.setBrandKeyName(ob.getBrandKeyName());
			System.out.println("ob.getBrandKeyName()..1. "+slidersDto.getBrandKeyName());
			String imageUrl = ob.getImageUrlList();
			System.out.println("imageUrls... "+imageUrl);
			List<String> imageList = Arrays.asList(imageUrl.split(","));
			List<ImageUrls> imageUrlList = new ArrayList<ImageUrls>();

			for (String img : imageList) {
				ImageUrls imageUrls = new ImageUrls();
				imageUrls.setImageUrl(img);
				imageUrlList.add(imageUrls);
			}
			slidersDto.setImageUrls(imageUrlList);
			listOfSliders.add(slidersDto);
			
		}
		
		return listOfSliders;

	}
	

}