package lt.vu.mybatis.model;

public class Doctor {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.ID
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.NAME
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.SECTOR_ID
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    private Integer sectorId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.ID
     *
     * @return the value of PUBLIC.DOCTOR.ID
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.ID
     *
     * @param id the value for PUBLIC.DOCTOR.ID
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.NAME
     *
     * @return the value of PUBLIC.DOCTOR.NAME
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.NAME
     *
     * @param name the value for PUBLIC.DOCTOR.NAME
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.SECTOR_ID
     *
     * @return the value of PUBLIC.DOCTOR.SECTOR_ID
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    public Integer getSectorId() {
        return sectorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.SECTOR_ID
     *
     * @param sectorId the value for PUBLIC.DOCTOR.SECTOR_ID
     *
     * @mbg.generated Mon Apr 13 16:26:10 EEST 2020
     */
    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }
}