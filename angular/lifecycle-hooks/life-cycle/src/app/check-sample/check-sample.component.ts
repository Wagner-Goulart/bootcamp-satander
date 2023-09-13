import {
	Component,
	OnInit,
	DoCheck,
	AfterContentChecked,
	AfterContentInit,
	AfterViewChecked,
	AfterViewInit,
	OnDestroy
} from '@angular/core';

@Component({
	selector: 'app-check-sample',
	templateUrl: './check-sample.component.html',
	styleUrls: ['./check-sample.component.css'],
})
export class CheckSampleComponent
	implements
		OnInit,
		DoCheck,
		AfterContentChecked,
		AfterContentInit,
		AfterViewChecked,
		AfterViewInit,
		OnDestroy
{
	quantidade: number = 0;

	constructor() {}

	adicionar() {
		this.quantidade += +1;
	}

	decrementar() {
		this.quantidade += -1;
	}

	ngOnInit(): void {
		console.log('ngOnInit');
	}

	ngDoCheck(): void {
		console.log('ngDoCheck');
	}

	// Após algum alteração verifica o conteúdo
	ngAfterContentChecked(): void {
		console.log('ngAfterContentChecked');
	}

	// depois da inicialização dao View
	ngAfterViewChecked(): void {
		console.log('ngAfterViewChecked');
	}

	// após alguam alteração verifica a view
	ngAfterContentInit(): void {
		console.log('ngAfterContentInit');
	}

	// quando conteudo é iniciado
	ngAfterViewInit(): void {
		console.log('ngAfterViewInit');
	}

	ngOnDestroy(): void {
		console.log('Hasta la vista, Baby')
	}

}
