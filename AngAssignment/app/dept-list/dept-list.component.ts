import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataserveService } from '../dataserve.service';

@Component({
  selector: 'app-dept-list',
  templateUrl: './dept-list.component.html',
  styleUrls: ['./dept-list.component.css']
})
export class DeptListComponent implements OnInit {
  public dept: any;
  constructor(private router: Router, private service: DataserveService) { }

  ngOnInit() {
    this.service.deptObservable.subscribe(value => {
      this.dept = value;
    });
  }

  displayDetails(dept: any) {
    this.router.navigate(['/dept', dept.id]);
  }
}
