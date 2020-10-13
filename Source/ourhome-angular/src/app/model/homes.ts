export class HomesModel {
  id: number;
  user_id: number;
  description: string;
  price: number;
  urlPhotos: string;
  numBedrooms: number;
  numBathroom: number;
  city: string;
  direction: string;
  meters: number;
  floors: number;
  additional: string;
  createdAt: Date;
  updatedAt: Date;
  user: Object;
}
