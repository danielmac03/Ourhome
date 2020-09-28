import { Component, OnInit } from '@angular/core';
import * as jQuery from 'jquery';

@Component({
  selector: 'app-create-test',
  templateUrl: './create-test.component.html',
  styleUrls: ['./create-test.component.css', '../app.component.css']
})
export class CreateTestComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  add(){
    var contador = 0;
    contador = parseInt( jQuery("#contador").val() );
    var idInput = "#preguntaInput" + contador;
    var nombreRadions = "preguntaRadio" + contador;

    if((jQuery(idInput).val() != "") && jQuery("input[name='"+ nombreRadions +"']:checked").val()){
        contador = parseInt(jQuery("#contador").val()) + 1;

        jQuery("#contador").val(parseInt(contador));
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

        jQuery("#content_questions").append(question);
    }else{
        alert("Aún no has acabado la pregunta anterior")
    }
  }

}
