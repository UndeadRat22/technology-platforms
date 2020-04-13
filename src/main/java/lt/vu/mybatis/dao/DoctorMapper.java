package lt.vu.mybatis.dao;
import lt.vu.mybatis.model.Doctor;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DOCTOR
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DOCTOR
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    int insert(Doctor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DOCTOR
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    Doctor selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DOCTOR
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    List<Doctor> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DOCTOR
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    int updateByPrimaryKey(Doctor record);
}