$("#addQuestion").click(function(){
    var contador = $("#contador").val();
    var idInput = "#preguntaInput"+contador;
    var nombreRadions = "preguntaRadio"+contador;

    if(($(idInput).val() != "") && $("input[name='"+ nombreRadions +"']:checked").val()){
        contador = parseInt($("#contador").val())+1;

        $("#contador").val(parseInt(contador));
        var question = `<div class="form-group question p-2">
        <div class="form-group mt-3 field">
            <input type="text" id="preguntaInput` + contador + `" placeholder=" " class="form-control" required>
            <label class="lab" for="preguntaInput` + contador + `">Escribe tu pregunta</label>
        </div>

        <div class="form-check">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="preguntaRadio` + contador + `" value="1" required>Si
            </label>
        </div>
        <div class="form-check">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="preguntaRadio` + contador + `" value="0">No
            </label>
        </div>
    </div>`;

        $("#content_questions").append(question);
    }else{
        alert("Aún no has acabado la pregunta anterior")
    }    
});