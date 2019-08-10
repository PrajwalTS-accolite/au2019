import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetailsComponent } from './details/details.component';
import { ListComponent } from './list/list.component';
import { DeptListComponent } from './dept-list/dept-list.component';
import { TodoComponent } from './todo/todo.component';
import { DeptDetailsComponent } from './dept-details/dept-details.component';


const routes: Routes = [{ path: "emp/:id", component: DetailsComponent },
{ path: "employees", component: ListComponent },
{ path: "department", component: DeptListComponent },
{ path: "dept/:id", component: DeptDetailsComponent },
{ path: "todo", component: TodoComponent },
{ path: "todo/emp/:id", component: TodoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
