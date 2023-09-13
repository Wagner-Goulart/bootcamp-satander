import { Component, OnInit, OnChanges, Input } from '@angular/core';

@Component({
	selector: 'app-title',
	templateUrl: './title.component.html',
	styleUrls: ['./title.component.css'],
})
export class TitleComponent implements OnInit, OnChanges {
	@Input() nome: string = '';

	constructor() {
		console.log(`construtor ${this.nome}`)
	}

	ngOnChanges(): void {
		console.log(`OnChanges ${this.nome}`)
	}

	ngOnInit(): void {
		this.nome = this.nome + ' X'
		console.log(`OnInit ${this.nome}`)
	}


}
