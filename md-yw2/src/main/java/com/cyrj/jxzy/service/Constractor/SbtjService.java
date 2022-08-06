package com.cyrj.jxzy.service.Constractor;

import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.SbtjEntity;

public interface SbtjService {

	Map<String, Object>showList(SbtjEntity entity, Pager pager);
}
