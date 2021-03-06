package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Sector;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface SectorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SECTOR
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SECTOR
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    int insert(Sector record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SECTOR
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    Sector selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SECTOR
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    List<Sector> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SECTOR
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    int updateByPrimaryKey(Sector record);
}