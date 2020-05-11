<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Send to friend</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Sender email:</label> <input id="sender" type="text"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Receive email:</label> <input id="email" type="email"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Comments :</label>
					<textarea id="comments" class="form-control" rows="3"></textarea>
				</div>
				<input type="hidden" id="id" />
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				
				<button class="btn btn-primary" type="button" id="btn-send" disabled>
  <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
  Send
</button>
			</div>
		</div>
	</div>
</div>