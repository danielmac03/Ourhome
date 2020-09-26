import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { casas } from '../model/casas';
import { CasasService } from '../service/casas.service';


@Component({
  selector: 'app-ver-anuncio',
  templateUrl: './ver-anuncio.component.html',
  styleUrls: ['./ver-anuncio.component.css', '../app.component.css']
})
export class VerAnuncioComponent implements OnInit {

  id: number;
  casas: casas;

  constructor(private route: ActivatedRoute,private router: Router,
    private casasService: CasasService) { }

  ngOnInit() {
    this.casas = new casas();

    this.id = this.route.snapshot.params['id'];

    this.casasService.getCasas(this.id)
      .subscribe(data => {
        console.log(data)
        this.casas = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['casas']);
  }


}
