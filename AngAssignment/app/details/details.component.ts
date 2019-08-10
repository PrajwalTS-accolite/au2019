import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataserveService } from '../dataserve.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  public empDetails: any;
  @Input() id: number;
  
  constructor(private route: ActivatedRoute, private router: Router, private dataService: DataserveService) { }

  ngOnInit() {
      this.route.params.subscribe(value => {
        let id = +value.id;
        this.empDetails = this.dataService.retrieveEmpFromId(id);
      });
  }

}
