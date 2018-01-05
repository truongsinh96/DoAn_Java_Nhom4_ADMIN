<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<input type="hidden" id="dateLuongNv" value="${param.year}" />

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Xem lương nhân viên</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-md-4">
                            Lương nhân viên năm 2018
                        </div>
                        <div class="col-md-5 col-md-offset-1">
                            <div class="form-group form-inline">
                                <label class="control-label">Chọn năm:</label>
                                <div class="input-group date" id="chon-nam-luong-nv">
                                    <input type="text" class="form-control" style="border: 1px solid #cccccc;">
                                    <div class="input-group-addon">
                                        <span class="fa fa-calendar"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <a href="<c:url value="/chinhanh/chiphi/thang/create"/>" class="btn btn-primary fix pull-right">Thêm lương nhân viên</a>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped custab table-don-hang">
                        <thead>
                        <tr>
                            <th class="text-center red-text-table">Tháng</th>
                            <th class="text-center">Năm</th>
                            <th class="text-center">Ngày chi</th>
                            <th class="text-center">Tổng tiền</th>
                            <th width="5%"></th>
                            <th width="5%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listTongLuongTheoThang}" var="tongLuongTheoThang">
                        <tr>
                            <td class="text-center red-text-table">${tongLuongTheoThang.thang}</td>
                            <td class="text-center">${tongLuongTheoThang.nam}</td>
                            <td class="text-center"><fmt:formatDate value="${tongLuongTheoThang.ngayChi}" pattern="dd/MM/yyyy" /></td>
                            <td class="text-center">${tongLuongTheoThang.tongTien} VNĐ </td>
                            <td>
                                <a class="btn btn-warning">Sửa</a>
                            </td>
                            <td>
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>