package com.sydx.aqsc.entity.Security;

import com.sydx.aqsc.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * 施工施工参数
 * 2019.11.02
 */
@ApiModel(value = "施工施工参数")
public class GxcsEntity extends BaseEntity {

    private String oilfield;
    private String circuit_id;//工序id
    private String circuit_name;//工序名称
    private String table_head;//参数字段table_head
    private String table_head_chs;//参数名称
    private String show_or_not;//是否显示
    private int field_sq;//字段顺序
    private int field_length;//字段数据类型长度
    private int field_accuracy;//字段精度
    private String unit;//单位
    private String cell_type;//单元格类型（文本框，下拉列表，复选框）
    private String code_associate_field;//标准的工具名称对应的表的字段
    private String code_associate_table;//标准的工具名称对应的表
    private String multi_row;//是否是多行，0表示是单行数据，1表示是多行数据
    private String is_null;//是否为空
    private String is_null_oil;//是否为空
    private String is_show_oil;//是否为空
    private String is_show;//是否选择
    private String field_type;//字段数据类型
    private String stipulate;//填写规定
    private Integer spid;//填写规定
    private String unit_id;//填写规定
    private String bz;//数据表注释
    private String qx;
    private String xg;//数据表修改
    private String drop;//数据表注释
    private String sgdyid;//施工单元id
    private String sgdymc;//施工单元名称
    private List<GxcsEntity> entityList;

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getIs_null_oil() {
        return is_null_oil;
    }

    public void setIs_null_oil(String is_null_oil) {
        this.is_null_oil = is_null_oil;
    }

    public String getIs_show_oil() {
        return is_show_oil;
    }

    public void setIs_show_oil(String is_show_oil) {
        this.is_show_oil = is_show_oil;
    }

    public String getIs_show() {
        return is_show;
    }

    public void setIs_show(String is_show) {
        this.is_show = is_show;
    }

    public String getUnit_id() {
        return unit_id;
    }
    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getXg() {
        return xg;
    }

    public void setXg(String xg) {
        this.xg = xg;
    }

    public String getDrop() {
        return drop;
    }
    public void setDrop(String drop) {
        this.drop = drop;
    }
    public String getBz() {
        return bz;
    }
    public void setBz(String bz) {
        this.bz = bz;
    }
    public int getField_length() {
        return field_length;
    }
    public void setField_length(int field_length) {
        this.field_length = field_length;
    }
    public List<GxcsEntity> getEntityList() {
        return entityList;
    }
    public void setEntityList(List<GxcsEntity> entityList) {
        this.entityList = entityList;
    }
    public String getOilfield() {
        return oilfield;
    }

    public void setOilfield(String oilfield) {
        this.oilfield = oilfield;
    }

    public String getCircuit_id() {
        return circuit_id;
    }

    public void setCircuit_id(String circuit_id) {
        this.circuit_id = circuit_id;
    }

    public String getTable_head() {
        return table_head;
    }

    public void setTable_head(String table_head) {
        this.table_head = table_head;
    }

    public String getTable_head_chs() {
        return table_head_chs;
    }

    public void setTable_head_chs(String table_head_chs) {
        this.table_head_chs = table_head_chs;
    }

    public String getShow_or_not() {
        return show_or_not;
    }

    public void setShow_or_not(String show_or_not) {
        this.show_or_not = show_or_not;
    }

    public int getField_sq() {
        return field_sq;
    }

    public void setField_sq(int field_sq) {
        this.field_sq = field_sq;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCell_type() {
        return cell_type;
    }

    public void setCell_type(String cell_type) {
        this.cell_type = cell_type;
    }

    public String getCode_associate_field() {
        return code_associate_field;
    }

    public void setCode_associate_field(String code_associate_field) {
        this.code_associate_field = code_associate_field;
    }

    public String getCode_associate_table() {
        return code_associate_table;
    }

    public void setCode_associate_table(String code_associate_table) {
        this.code_associate_table = code_associate_table;
    }

    public String getMulti_row() {
        return multi_row;
    }

    public void setMulti_row(String multi_row) {
        this.multi_row = multi_row;
    }

    public String getIs_null() {
        return is_null;
    }

    public void setIs_null(String is_null) {
        this.is_null = is_null;
    }

    public String getField_type() {
        return field_type;
    }

    public void setField_type(String field_type) {
        this.field_type = field_type;
    }

    public String getStipulate() {
        return stipulate;
    }

    public void setStipulate(String stipulate) {
        this.stipulate = stipulate;
    }

    public int getField_accuracy() {
        return field_accuracy;
    }

    public void setField_accuracy(int field_accuracy) {
        this.field_accuracy = field_accuracy;
    }

    public String getSgdyid() {
        return sgdyid;
    }

    public void setSgdyid(String sgdyid) {
        this.sgdyid = sgdyid;
    }

    public String getSgdymc() {
        return sgdymc;
    }

    public void setSgdymc(String sgdymc) {
        this.sgdymc = sgdymc;
    }

    @Override
    public String getQx() {
        return qx;
    }

    @Override
    public void setQx(String qx) {
        this.qx = qx;
    }

    public String getCircuit_name() {
        return circuit_name;
    }

    public void setCircuit_name(String circuit_name) {
        this.circuit_name = circuit_name;
    }

    @Override
    public String toString() {
        return "GxcsEntity{" +
                "circuit_id='" + circuit_id + '\'' +
                ", table_head='" + table_head + '\'' +
                ", table_head_chs='" + table_head_chs + '\'' +
                ", show_or_not='" + show_or_not + '\'' +
                ", field_sq=" + field_sq +
                ", unit='" + unit + '\'' +
                ", cell_type='" + cell_type + '\'' +
                ", code_associate_field='" + code_associate_field + '\'' +
                ", code_associate_table='" + code_associate_table + '\'' +
                ", multi_row='" + multi_row + '\'' +
                ", is_null='" + is_null + '\'' +
                ", field_type='" + field_type + '\'' +
                ", stipulate='" + stipulate + '\'' +
                '}';
    }
}
