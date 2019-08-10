import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataserveService } from '../dataserve.service';

@Component({
  selector: 'app-dept-details',
  templateUrl: './dept-details.component.html',
  styleUrls: ['./dept-details.component.css']
})
export class DeptDetailsComponent implements OnInit {

  public deptDetails: any;
  constructor(private route: ActivatedRoute, private router: Router, private dataService: DataserveService) { }

  ngOnInit() {
    this.route.params.subscribe(value => {
      let id = +value.id;
      this.deptDetails = this.dataService.retrieveDeptFromId(id);
    });
  }

}
