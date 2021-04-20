import '../common/cell_info.dart';

class LTEParameters extends BasicCellInfo {
  int eci;
  int enb;
  int cid;
  int tac;
  int pci;
  int bandWidth;
  int rssi;
  double rsrp;
  double rsrq;
  int cqi;
  int timingAdvance;
  double snr;

  LTEParameters({
    this.eci,
    this.enb,
    this.cid,
    this.tac,
    this.pci,
    this.bandWidth,
    this.rssi,
    this.rsrp,
    this.rsrq,
    this.cqi,
    this.timingAdvance,
    this.snr,
  });

  LTEParameters.fromJson(Map<String, dynamic> map) {
    this.eci = map['eci'];
    this.enb = map['enb'];
    this.cid = map['cid'];
    this.tac = map['tac'];
    this.pci = map['pci'];
    this.bandWidth = map['bandWidth'];
    this.rssi = map['rssi'];
    this.rsrp = map['rsrp'];
    this.rsrq = map['rsrq'];
    this.cqi = map['cqi'];
    this.timingAdvance = map['timingAdvance'];
    this.snr = map['snr'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['eci'] = this.eci;
      data['enb'] = this.enb;
      data['cid'] = this.cid;
      data['tac'] = this.tac;
      data['pci'] = this.pci;
      data['bandWidth'] = this.bandWidth;
      data['rssi'] = this.rssi;
      data['rsrp'] = this.rsrp;
      data['rsrq'] = this.rsrq;
      data['cqi'] = this.cqi;
      data['timingAdvance'] = this.timingAdvance;
      data['snr'] = this.snr;
      return data;
    }
  }
}