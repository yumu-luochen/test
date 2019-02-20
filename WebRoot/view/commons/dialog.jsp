<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/view/commons/taglibs.jsp"%>
<!-- 通用提示窗口  -->
<div class="modal fade" id="msgModal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">系统提示</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="msgInfo"></p>
			</div>
			<div class="modal-footer">
				<input type="button" name="Submit"  class="btn btn-primary" onclick="javascript:history.back(-1);" value="关闭">
			</div>
		</div>
	</div>
</div>

<c:if test="${not empty errMsg }">
	<script type="text/javascript">
	       $("#msgInfo").text('${errMsg}');
	       $('#msgModal').modal();
	    </script>
</c:if>
