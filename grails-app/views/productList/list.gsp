<!DOCTYPE html>
<html lang="en">
<g:render template="/layouts/head"/>
<body>
<g:render template="/layouts/navigation"/>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-12 text-center">
            <div style="padding-top: 100px" class="text-justify col-lg-12">
                <form class="form-horizontal col-lg-12" action="list" role="search" method="get">
                    <div class="form-group">
                        <label class="col-lg-12" for="query">Search for products:</label>
                        <g:textField style="float:left; width: 90% !important;" type="search" name="query" value="${params.query}" class="form-control col-lg-8" placeholder="Search"/>
                        <button style="float: right; width: 10%" type="submit" class="btn btn-default col-lg-4"><span class="glyphicon glyphicon-search"></span></button>
                    </div>
                </form>
                <div class="col-lg-12 text-center">
                    <g:if test="${flash.error}">
                        <div class="alert alert-danger" role="status">${flash.error}</div>
                    </g:if>
            </div>
                <g:each in="${products}" var="product" status="i">
                    <a class="list-group-item col-lg-12" href=${createLink(controller: 'productViewer', action: 'show', params: ['barCode': product.barCode])}>
                        <p>
                            ${product?.barCode}
                        </p>
                        <p style="width: 100%; white-space: nowrap; overflow: hidden; text-overflow: ellipsis">
                            ${product?.description}
                        </p>
                    </a>
                </g:each>

            </div>
        </div>

        <g:if test="${products.size() < productsCount}">
            <div class="pagination list-group-item col-lg-12">
                <g:paginate controller="productList" action="list" total="${productsCount}" />
            </div>
        </g:if>
    </div>
</div>
</div>

</body>

</html>