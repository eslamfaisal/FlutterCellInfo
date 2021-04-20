import 'package:cell_info/models/common/cell_info.dart';

class WCDMAParameters extends BasicCellInfo {
  int ci;
  int rnc;
  int cid;
  int lac;
  int psc;
  int rssi;
  int bitErrorRate;
  int rscp;
  int ecio;
  int ecno;

  WCDMAParameters({
    this.ci,
    this.rnc,
    this.cid,
    this.lac,
    this.psc,
    this.rssi,
    this.bitErrorRate,
    this.rscp,
    this.ecio,
    this.ecno,
  });

  WCDMAParameters.fromJson(Map<String, dynamic> map) {
    this.ci = map['ci'];
    this.rnc = map['rnc'];
    this.cid = map['cid'];
    this.lac = map['lac'];
    this.psc = map['psc'];
    this.rssi = map['rssi'];
    this.bitErrorRate = map['bitErrorRate'];
    this.rscp = map['rscp'];
    this.ecio = map['ecio'];
    this.ecno = map['ecno'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['ci'] = this.ci;
      data['rnc'] = this.rnc;
      data['cid'] = this.cid;
      data['lac'] = this.lac;
      data['psc'] = this.psc;
      data['rssi'] = this.rssi;
      data['bitErrorRate'] = this.bitErrorRate;
      data['rscp'] = this.rscp;
      data['ecio'] = this.ecio;
      data['ecno'] = this.ecno;
      return data;
    }
  }
}