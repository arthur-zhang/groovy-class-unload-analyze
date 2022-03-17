package com.yuping.app214c2d6e_8f0e_209a_7cbf_81130c799181

import com.imdach.demo.BaseClazz

class bookDataModel extends BaseClazz {
    String classify
    String editor
    Boolean isPaper
    Integer wordCount
    String author
    String charter
    String authorInfo
    String icon
    String title
    Double price
    String series
    String name
    Integer page
    String planner
    String mark
    String info

    public List enumClassify() {
        return "小说|名著|教材|政治|考试".split("\\|").toList()
    }

    public List<String> verify() {
        List<String> errList = new ArrayList()
        if (getClassify() == null) {
            errList.add("classify cannot be empty;")
        }
        if (getClassify() != null && !enumClassify().contains(getClassify())) {
            errList.add("classify is not included in enums;")
        }
        if (getTitle() == null) {
            errList.add("title cannot be empty;")
        }
        if (getPrice() == null) {
            errList.add("price cannot be empty;")
        }
        if (getPrice() != null && getPrice() < 0) {
            errList.add("price cannot < 0;")
        }
        if (getPrice() != null && getPrice() > 100000) {
            errList.add("price cannot > 100000;")
        }
        if (getName() == null) {
            errList.add("name cannot be empty;")
        }
        if (getInfo() == null) {
            errList.add("info cannot be empty;")
        }
        return errList
    }

    public Map<String, List> enums() {
        Map<String, List> enums = new HashMap<>()
        enums.put("classify", enumClassify())
    }

}
