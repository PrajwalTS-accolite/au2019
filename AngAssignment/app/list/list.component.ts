import { Component, OnInit } from '@angular/core';
import { DataserveService } from '../dataserve.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  public emp: any;

  constructor(private router: Router, private service: DataserveService, private route: ActivatedRoute) { }
  isTodo: boolean = null;

  ngOnInit() {
    this.service.empObservable.subscribe(value => {
      this.emp = value;
    });
    if (this.route.snapshot.routeConfig.path.startsWith('todo'))
      this.isTodo = true;
    else
      this.isTodo = false;
  }

  displayDetails(emp: any) {
    if (this.isTodo)
      this.router.navigate(['/todo/emp', emp.id]);
    else
      this.router.navigate(['/emp', emp.id]);
  }

  deleteElem(elem: any) {
    let newList = this.delArray(this.emp, elem);
    this.service.setEmpList(newList);
  }

  delArray(list, value) {
    return list.filter(function (elem) {
      return elem != value;
    });
  }
}
