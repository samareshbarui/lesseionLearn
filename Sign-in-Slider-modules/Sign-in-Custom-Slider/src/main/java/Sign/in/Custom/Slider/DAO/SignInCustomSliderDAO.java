package Sign.in.Custom.Slider.DAO;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Sign.in.Custom.Slider.DTO.SignInCustomSliderDTO;

public class SignInCustomSliderDAO {
	
	private static final Log logger = LogFactoryUtil.getLog(SignInCustomSliderDAO.class);
	
	public List<SignInCustomSliderDTO> getAllSliders() throws SQLException {
		logger.info("calling.......");
		String sqlQuery = "";
		sqlQuery = ("SELECT brandId, userName, DATE_FORMAT(modifiedDate,'%d %M, %Y') AS DATE ,COUNT(*) AS Image_Count FROM jwc_signin GROUP BY brandId ");
		List<SignInCustomSliderDTO> sliderDTOs = new ArrayList<SignInCustomSliderDTO>();
		Connection connection = DataAccess.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		logger.info("resultSet:::::::::" + resultSet);
		while (resultSet.next()) {
			
			SignInCustomSliderDTO customSliderDTO = new SignInCustomSliderDTO();
			long brandId = resultSet.getLong("brandId");
			customSliderDTO.setBrandId(brandId);
			String userName = resultSet.getString("userName");
			customSliderDTO.setUserName(userName);
			String date = resultSet.getString("DATE");
			customSliderDTO.setDate(date);
			int imageCount = resultSet.getInt("Image_Count");
			customSliderDTO.setImageCount(imageCount);
			sliderDTOs.add(customSliderDTO);
			logger.info("BrandId..." + customSliderDTO.getBrandId());
			logger.info("UserName..." + customSliderDTO.getUserName());
		}
		
		return sliderDTOs;
	}
}
