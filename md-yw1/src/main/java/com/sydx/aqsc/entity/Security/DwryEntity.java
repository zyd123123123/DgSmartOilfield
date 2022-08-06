package com.sydx.aqsc.entity.Security;


import com.sydx.aqsc.entity.Admin.BaseEntity;
import com.sydx.aqsc.entity.Admin.Pager;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

public class DwryEntity extends BaseEntity {
    /**
         *   表字段 : DW
     */
    private String dw;
    private String yjdw;//一级单位
    private String ejdw;//二级单位
    private String sjdw;//三级单位
    private String bzmc;//班组名称
    private String unitname;
    private String sfzh;
    private String is_use;
    private String oilfield;
    private String fileurl;
    private String rymb_id;
    private Pager pager;//分页
    private String flag;
    private File upload;
    private String uploadFileName;
    private MultipartFile file;
    private String zslx;
    private String unitid_new;
	/**
         *   表字段 : SJ
     */
    private Date sj;

    /**
         *   表字段 : XH
     */
    private Short xh;

    /**
         *   表字段 : XM
     */
    private String xm;

    /**
         *   表字段 : NL
     */
    private Short nl;

    /**
         *   表字段 : ZW
     */
    private String zw;

    /**
         *   表字段 : CSSJ
     */
    private String cssj;

    /**
         *   表字段 : XL
     */
    private String xl;

    /**
         *   表字段 : ZC
     */
    private String zc;

    /**
         *   表字段 : JKPXZSJ
     */
    private Date jkpxzsj;
    private String jkpxzsjs;

    /**
         *   表字段 : JKPXZBH
     */
    private String jkpxzbh;

    /**
         *   表字段 : FZDW
     */
    private String fzdw;

    /**
         *   表字段 : BZ
     */
    private String bz;

    /**
         *   表字段 : CYC
     */
    private String cyc;

    /**
         *   表字段 : LRR
     */
    private String lrr;
    private String xgr;
    private String lrsjs;

    /**
         *   表字段 : LRSJ
     */
    private Date lrsj;
    private Date xgsj;

    /**
         *   表字段 : SHR
     */
    private String shr;

    /**
         *   表字段 : SHSJ
     */
    private Date shsj;

    /**
         *  字段注释 : 性别
         *   表字段 : XB
     */
    private String xb;

    /**
         *  字段注释 : 岗位属性
         *   表字段 : GWSX
     */
    private String gwsx;

    /**
         *  字段注释 : 劳动关系
         *   表字段 : LDGX
     */
    private String ldgx;

    /**
         *  字段注释 : 出生年月
         *   表字段 : CSNY
     */
    private Date csny;
    private String csnys;

    /**
         *  字段注释 : 三级单位
         *   表字段 : THIRD
     */
    private String second;
    private String third;

    /**
         *  字段注释 : 四级单位
         *   表字段 : FOURTH
     */
    private String fourth;

    /**
         *  字段注释 : 人员ID
         *   表字段 : RRID
     */
    private String rrid;

    /**
         *  字段注释 : 队伍ID
         *   表字段 : UNITID
     */
    private String unitid;
    private List<DwryEntity> entityList;
    
    
    public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getRymb_id() {
		return rymb_id;
	}

	public void setRymb_id(String rymb_id) {
		this.rymb_id = rymb_id;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
    public List<DwryEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<DwryEntity> entityList) {
		this.entityList = entityList;
	}

	public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw == null ? null : dw.trim();
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public Short getXh() {
        return xh;
    }

    public void setXh(Short xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Short getNl() {
        return nl;
    }

    public void setNl(Short nl) {
        this.nl = nl;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw == null ? null : zw.trim();
    }

    public String getCssj() {
        return cssj;
    }

    public void setCssj(String cssj) {
        this.cssj = cssj == null ? null : cssj.trim();
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl == null ? null : xl.trim();
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc == null ? null : zc.trim();
    }

    public Date getJkpxzsj() {
        return jkpxzsj;
    }

    public void setJkpxzsj(Date jkpxzsj) {
        this.jkpxzsj = jkpxzsj;
    }

    public String getJkpxzbh() {
        return jkpxzbh;
    }

    public void setJkpxzbh(String jkpxzbh) {
        this.jkpxzbh = jkpxzbh == null ? null : jkpxzbh.trim();
    }

    public String getFzdw() {
        return fzdw;
    }

    public void setFzdw(String fzdw) {
        this.fzdw = fzdw == null ? null : fzdw.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getCyc() {
        return cyc;
    }

    public void setCyc(String cyc) {
        this.cyc = cyc == null ? null : cyc.trim();
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr == null ? null : lrr.trim();
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr == null ? null : shr.trim();
    }

    public Date getShsj() {
        return shsj;
    }

    public void setShsj(Date shsj) {
        this.shsj = shsj;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    public String getGwsx() {
        return gwsx;
    }

    public void setGwsx(String gwsx) {
        this.gwsx = gwsx == null ? null : gwsx.trim();
    }

    public String getLdgx() {
        return ldgx;
    }

    public void setLdgx(String ldgx) {
        this.ldgx = ldgx == null ? null : ldgx.trim();
    }

    public Date getCsny() {
        return csny;
    }

    public void setCsny(Date csny) {
        this.csny = csny;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third == null ? null : third.trim();
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth == null ? null : fourth.trim();
    }

    public String getRrid() {
        return rrid;
    }

    public void setRrid(String rrid) {
        this.rrid = rrid == null ? null : rrid.trim();
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid ;
    }

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	/**
	 * @return the jkpxzsjs
	 */
	public String getJkpxzsjs() {
		return jkpxzsjs;
	}

	/**
	 * @param jkpxzsjs the jkpxzsjs to set
	 */
	public void setJkpxzsjs(String jkpxzsjs) {
		this.jkpxzsjs = jkpxzsjs;
	}

	/**
	 * @return the csnys
	 */
	public String getCsnys() {
		return csnys;
	}

	/**
	 * @param csnys the csnys to set
	 */
	public void setCsnys(String csnys) {
		this.csnys = csnys;
	}

	/**
	 * @return the oilfield
	 */
	public String getOilfield() {
		return oilfield;
	}

	/**
	 * @param oilfield the oilfield to set
	 */
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	/**
	 * @return the xgr
	 */
	public String getXgr() {
		return xgr;
	}

	/**
	 * @param xgr the xgr to set
	 */
	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	/**
	 * @return the xgsj
	 */
	public Date getXgsj() {
		return xgsj;
	}

	/**
	 * @param xgsj the xgsj to set
	 */
	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	/**
	 * @return the is_use
	 */
	public String getIs_use() {
		return is_use;
	}

	/**
	 * @param is_use the is_use to set
	 */
	public void setIs_use(String is_use) {
		this.is_use = is_use;
	}

	/**
	 * @return the lrsjs
	 */
	public String getLrsjs() {
		return lrsjs;
	}

	/**
	 * @param lrsjs the lrsjs to set
	 */
	public void setLrsjs(String lrsjs) {
		this.lrsjs = lrsjs;
	}

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    public String getYjdw() {
        return yjdw;
    }

    public void setYjdw(String yjdw) {
        this.yjdw = yjdw;
    }

    public String getEjdw() {
        return ejdw;
    }

    public void setEjdw(String ejdw) {
        this.ejdw = ejdw;
    }

    public String getSjdw() {
        return sjdw;
    }

    public void setSjdw(String sjdw) {
        this.sjdw = sjdw;
    }

    public String getBzmc() {
        return bzmc;
    }

    public void setBzmc(String bzmc) {
        this.bzmc = bzmc;
    }

    public String getUnitid_new() {
        return unitid_new;
    }

    public void setUnitid_new(String unitid_new) {
        this.unitid_new = unitid_new;
    }
}