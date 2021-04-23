import 'package:cell_info/models/common/cell_info.dart';

class CDMAParameters extends BasicCellInfo {
  int nid;
  int bid;
  double lat;
  double lon;
  double cdmaEcio;
  int cdmaRssi;
  double evdoEcio;
  int evdoRssi;
  int evdoSnr;

  CDMAParameters({
    this.nid,
    this.bid,
    this.lat,
    this.lon,
    this.cdmaEcio,
    this.cdmaRssi,
    this.evdoEcio,
    this.evdoRssi,
    this.evdoSnr,
  });

  CDMAParameters.fromJson(Map<String, dynamic> map) {
    this.nid = map['nid'];
    this.bid = map['bid'];
    this.lat = map['lat'];
    this.lon = map['lon'];
    this.cdmaEcio = map['cdmaEcio'];
    this.cdmaRssi = map['cdmaRssi'];
    this.evdoEcio = map['evdoEcio'];
    this.evdoRssi = map['evdoRssi'];
    this.evdoSnr = map['evdoSnr'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['nid'] = this.nid;
      data['bid'] = this.bid;
      data['lat'] = this.lat;
      data['lon'] = this.lon;
      data['cdmaEcio'] = this.cdmaEcio;
      data['cdmaRssi'] = this.cdmaRssi;
      data['evdoEcio'] = this.evdoEcio;
      data['evdoRssi'] = this.evdoRssi;
      data['evdoSnr'] = this.evdoSnr;
      return data;
    }
  }
}