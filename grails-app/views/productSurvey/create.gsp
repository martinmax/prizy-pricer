<!DOCTYPE html>
<html lang="en">
<g:render template="/layouts/head"/>
<body>
<g:render template="/layouts/navigation"/>
<!-- Page Content -->
<div class="container">

    <div class="row">
        <div class="col-lg-12 text-center">
            <div style="padding-top: 50px">
                <h3>Enter product</h3>
                <g:if test="${flash.message}">
                        <div class="alert alert-success" role="status">${flash.message}</div>
                </g:if>
                <g:if test="${flash.error}">
                    <div class="alert alert-danger" role="status">${flash.error}</div>
                </g:if>
                <p>&nbsp;</p>
                <g:form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="store">${g.message(code:'survey.store.name',default: 'Store')}:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="store" name="store" placeholder="${g.message(code:'survey.enter.store.name',default: 'Enter store name')}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="barCode">${g.message(code:'survey.product.bar.code',default: 'Bar Code')}:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="barCode" name="barCode" placeholder="${g.message(code:'survey.enter.product.bar.code',default: 'Enter Bar Code')}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="price">${g.message(code:'survey.price',default: 'Price')}:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="price" name="price" placeholder="${g.message(code:'survey.enter.price',default: 'Enter Price')}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="note">${g.message(code:'survey.note',default: 'Note')}:</label>
                        <div class="col-sm-10">
                            <textarea type="text" class="form-control" id="note" name="note"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-1 col-sm-10">
                            <g:actionSubmit id="saveButton" value="${g.message(code:'survey.submit',default: 'Submit')}" action="save" class="btn btn-default"/>
                        </div>
                    </div>
                </g:form>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.container -->
</body>

</html>