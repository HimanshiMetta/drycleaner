import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { CartComponent } from './cart/cart.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { LoginComponent } from './login/login.component';
import { PaymentComponent } from './payment/payment.component';
import { ProcessingComponent } from './processing/processing.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { UpdateProductFormComponent } from './update-product-form/update-product-form.component';

const routes: Routes = [
  {path: 'cart', component: CartComponent},
  {path: 'product', component: ListProductsComponent},
  {path: 'addProduct', component: ProductFormComponent},
  {path: 'updateProduct/:id', component: UpdateProductFormComponent},
  {path: 'login', component:LoginComponent},
  {path: 'payment', component:PaymentComponent},
  {path: '', component:AboutComponent},
  {path: 'completed', component:ProcessingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }