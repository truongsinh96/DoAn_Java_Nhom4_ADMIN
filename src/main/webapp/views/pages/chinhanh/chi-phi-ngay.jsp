<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Chi phí theo ngày</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Danh sách chi phí theo ngày
                    <button type="button" class="btn btn-primary fix pull-right" data-toggle="modal" data-target="#modal-them-chi-phi-ngay">Thêm chi phí mới</button>
                </div>
                <div class="modal fade" id="modal-them-chi-phi-ngay">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <b>Nhập thông tin chi phí mới</b>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <form class="form-horizontal">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="ten-chi-phi">Tên chi phí</label>
                                        <div class="col-md-7">
                                            <input class="form-control expanded-input" id="ten-chi-phi" name="ten-chi-phi">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="mo-ta">Mô tả</label>
                                        <div class="col-md-7">
                                            <textarea class="form-control expanded-input" id="mo-ta" name="mo-ta" rows="8"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="tieu-hao">Tiêu hao</label>
                                        <div class="col-md-4">
                                            <input class="form-control expanded-input" id="tieu-hao" name="tieu-hao">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 16px" data-dismiss="modal">Đóng</button>
                                    <button type="submit" class="btn btn-success pull-right">Xác nhận</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped custab table-don-hang">
                        <thead>
                        <tr>
                            <th width="10%" class="text-center red-text-table">ID</th>
                            <th>Tên chi phí</th>
                            <th width="25%" class="text-center">Thời gian</th>
                            <th width="10%" class="text-center">Tổng tiền</th>
                            <th width="5%"></th>
                            <th width="5%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="text-center red-text-table">1</td>
                            <td>Mua thêm bột</td>
                            <td class="text-center"> 4:00PM 27/01/2017</td>
                            <td class="text-center">15000</td>
                            <td width="5%">
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-chi-phi-ngay">Sửa</a>
                            </td>
                            <td width="5%">
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-center red-text-table">2</td>
                            <td>Mua thêm bột</td>
                            <td class="text-center"> 5:00PM 28/01/2017</td>
                            <td class="text-center">15000</td>
                            <td width="5%">
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-chi-phi-ngay">Sửa</a>
                            </td>
                            <td width="5%">
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-center red-text-table">3</td>
                            <td>Mua thêm bột</td>
                            <td class="text-center"> 6:00PM 28/01/2017</td>
                            <td class="text-center">15000</td>
                            <td width="5%">
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-chi-phi-ngay">Sửa</a>
                            </td>
                            <td width="5%">
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-center red-text-table">4</td>
                            <td>Mua thêm bột</td>
                            <td class="text-center">10:00AM 29/01/2017</td>
                            <td class="text-center">15000</td>
                            <td width="5%">
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-chi-phi-ngay">Sửa</a>
                            </td>
                            <td width="5%">
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-center red-text-table">5</td>
                            <td>Mua thêm bột</td>
                            <td class="text-center">2:00PM 30/01/2017</td>
                            <td class="text-center">15000</td>
                            <td width="5%">
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-chi-phi-ngay">Sửa</a>
                            </td>
                            <td width="5%">
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal fade" id="modal-sua-chi-phi-ngay">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <b>Sửa thông tin chi phí #...</b>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <form class="form-horizontal">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="">Tên chi phí</label>
                                        <div class="col-md-7">
                                            <input class="form-control expanded-input" id="" name="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="mo-ta">Mô tả</label>
                                        <div class="col-md-7">
                                            <textarea class="form-control expanded-input" id="" name="" rows="8"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="tieu-hao">Tiêu hao</label>
                                        <div class="col-md-4">
                                            <input class="form-control expanded-input" id="" name="">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 16px" data-dismiss="modal">Đóng</button>
                                    <button type="submit" class="btn btn-success pull-right">Xác nhận</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>