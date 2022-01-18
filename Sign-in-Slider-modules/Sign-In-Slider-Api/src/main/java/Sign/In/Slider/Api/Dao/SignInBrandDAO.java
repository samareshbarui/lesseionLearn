package Sign.In.Slider.Api.Dao;

import com.jwc.signin.model.SignIn;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Sign.In.Slider.Api.Dto.SignInBrandDTO;


public class SignInBrandDAO {
	
	private static final Log logger = LogFactoryUtil.getLog(SignInBrandDAO.class);
	
	public List<SignInBrandDTO> getAllBrandSliders() throws SQLException {
		logger.info("calling.......");
		String sqlQuery = "";
		//sqlQuery = ("SELECT brandId, brandKeyName, imageUrl FROM jwc_signin a ,jwc_jwcbrandmaster b where a.brandId = b.brandId);
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a.brandId, b.brandKeyName, ");
		sb.append("GROUP_CONCAT( a.imageUrl ) AS \"imageUrl\" ");
		sb.append("FROM jwc_signin a,jwc_jwcbrandmaster b WHERE a.brandId = b.brandId GROUP BY a.brandId; ");
		List<SignInBrandDTO> sliderBrandDTOs = new ArrayList<SignInBrandDTO>();
		Connection connection = DataAccess.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sb.toString());
		logger.info("resultSet:::::::::" + resultSet);
		while (resultSet.next()) {
			
			SignInBrandDTO customSignInBrandDto = new SignInBrandDTO();
			long brandId = resultSet.getLong("brandId");
			customSignInBrandDto.setBrandId(brandId);
			String brandKeyName = resultSet.getString("brandKeyName");
			customSignInBrandDto.setBrandKeyName(brandKeyName);
			String imageUrl = resultSet.getString("imageUrl");
			customSignInBrandDto.setImageUrlList(imageUrl);
			sliderBrandDTOs.add(customSignInBrandDto);
			
		}
		
		return sliderBrandDTOs;
	}
}
